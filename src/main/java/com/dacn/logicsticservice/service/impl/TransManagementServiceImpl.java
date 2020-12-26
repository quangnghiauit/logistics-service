package com.dacn.logicsticservice.service.impl;

import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.dto.trans.*;
import com.dacn.logicsticservice.model.*;
import com.dacn.logicsticservice.repository.*;
import com.dacn.logicsticservice.service.TransManagementService;
import com.dacn.logicsticservice.utils.GsonUtils;
import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


import static com.dacn.logicsticservice.enumeration.ReturnCodeEnum.SUCCESSFUL;

@Service
public class TransManagementServiceImpl implements TransManagementService {

    private static Logger LOGGER = LoggerFactory.getLogger(TransManagementServiceImpl.class);

    private final CompanyRepository companyRepository;
    private final CustomerRepository customerRepository;
    private final CMLocationRepository locationRepository;
    private final CMRoutingRepository routingRepository;
    private final CMRulRateRepository rulRateRepository;
    private final CMContainerRepository containerRepository;
    private final RulsurChargeRepository rulsurChargeRepository;
    private final CMSurchargeRepository surchargeRepository;
    private final CMCurrencyRepository currencyRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public TransManagementServiceImpl(CompanyRepository companyRepository,
                                      CustomerRepository customerRepository,
                                      CMLocationRepository locationRepository,
                                      CMRoutingRepository routingRepository,
                                      CMRulRateRepository rulRateRepository,
                                      CMContainerRepository containerRepository,
                                      RulsurChargeRepository rulsurChargeRepository,
                                      CMSurchargeRepository surchargeRepository,
                                      CMCurrencyRepository currencyRepository,
                                      OrderRepository orderRepository) {

        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.routingRepository = routingRepository;
        this.rulRateRepository = rulRateRepository;
        this.containerRepository = containerRepository;
        this.rulsurChargeRepository = rulsurChargeRepository;
        this.surchargeRepository = surchargeRepository;
        this.currencyRepository = currencyRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public BaseResponseDTO<CompanyDTO> getAllCompany() {
        BaseResponseDTO<CompanyDTO> response = new BaseResponseDTO<>();
        List<CompanyDTO> companyDTOS = new ArrayList<>();

        try {
            List<Company> companies = companyRepository.getAllCompany();
            companies.stream().forEach(entity -> {
                CompanyDTO companyDTO = new CompanyDTO();
                companyDTO.mappingEntityToDTO(entity);
                companyDTOS.add(companyDTO);
            });

            response.success(SUCCESSFUL.getMessage(), companyDTOS);
        } catch (Exception e) {
            LOGGER.info("getAllCompany exception: {}", e);
            response.fail(e.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO<CustomerDTO> getAllCustomer() {
        BaseResponseDTO<CustomerDTO> response = new BaseResponseDTO<>();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        try {
            List<Customer> customers = customerRepository.getAllCustomer();
            customers.stream().forEach(entity -> {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.mappingEntityToDTO(entity);
                customerDTOS.add(customerDTO);
            });

            response.success(SUCCESSFUL.getMessage(), customerDTOS);
        } catch (Exception e) {
            LOGGER.info("getAllCustomer exception: {}", e);
            response.fail(e.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO<SuggestionResponseDTO> getAllSuggestions(SuggestRequest suggestRequest) {
        BaseResponseDTO<SuggestionResponseDTO> response = new BaseResponseDTO<>();
        try {
            String wardIdSender = suggestRequest.getWardIdSender();
            String districtIdSender = suggestRequest.getDistrictIdSender();
            String provinceIdSender = suggestRequest.getProvinceIdSender();
            String locDescriptionSender = suggestRequest.getLocDescriptionSender();
            String wardIdReceiver = suggestRequest.getWardIdReceiver();
            String districtIdReceiver = suggestRequest.getDistrictIdReceiver();
            String provinceIdReceiver = suggestRequest.getProvinceIdReceiver();
            String locDescriptionReceiver = suggestRequest.getLocDescriptionReceiver();

            CMLocation senderLocation = locationRepository.getCMLocationByCondition(wardIdSender, districtIdSender,
                    provinceIdSender, locDescriptionSender);
            LOGGER.info("senderLocation: {}", GsonUtils.toJsonString(senderLocation));

            CMLocation receiverLocation = locationRepository.getCMLocationByCondition(wardIdReceiver, districtIdReceiver,
                    provinceIdReceiver, locDescriptionReceiver);
            LOGGER.info("receiverLocation: {}", GsonUtils.toJsonString(receiverLocation));

            List<SuggestionResponseDTO> suggestionResponseDTOS = processSuggestions(senderLocation, receiverLocation);

            response.success(SUCCESSFUL.getMessage(), suggestionResponseDTOS);
        } catch (Exception ex) {
            LOGGER.info("getAllSuggestions exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO createOrder(OrderRequest request) {
        BaseResponseDTO response = new BaseResponseDTO();
        try {
            String wardIdReceiver = request.getWardIdReceiver();
            String districtIdReceiver = request.getDistrictIdReceiver();
            String provinceIdReceiver = request.getProvinceIdReceiver();
            String locDescriptionReceiver = request.getLocDescriptionReceiver();

            String wardIdSender = request.getWardIdSender();
            String districtIdSender = request.getDistrictIdSender();
            String provinceIdSender = request.getProvinceIdSender();
            String locDescriptionSender = request.getLocDescriptionSender();

            CMLocation receiverLocation = locationRepository.getCMLocationByCondition(wardIdReceiver, districtIdReceiver,
                    provinceIdReceiver, locDescriptionReceiver);
            LOGGER.info("receiverLocation: {}", GsonUtils.toJsonString(receiverLocation));

            CMLocation senderLocation = locationRepository.getCMLocationByCondition(wardIdSender, districtIdSender,
                    provinceIdSender, locDescriptionSender);
            LOGGER.info("senderLocation: {}", GsonUtils.toJsonString(senderLocation));

            Order order = new Order();
            order.doMappingEntity(request, receiverLocation, senderLocation);
            orderRepository.save(order);

            //producer kafka
//            producerOrderRequest(order);

            response.success(SUCCESSFUL.getMessage());
        } catch (Exception ex) {
            LOGGER.info("createOrder exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO getOrderByFilter(Integer cusId, Integer orderId, Integer companyId) {
        BaseResponseDTO response = new BaseResponseDTO();
        List<OrderDTO> orderDTOS = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        try {
            if (Objects.nonNull(cusId)) {
                orders = orderRepository.getAllByCusId(cusId);
                LOGGER.info("getOrderByFilter with customerId: {}, response: {}", cusId, GsonUtils.toJsonString(orders));
            }

            if (Objects.nonNull(orderId)) {
                orders = Collections.singletonList(orderRepository.getAllById(orderId));
                LOGGER.info("getOrderByFilter with orderId: {}, response: {}", orderId, GsonUtils.toJsonString(orders));
            }

            if (Objects.nonNull(companyId)) {
                List<RulRate> rulRates = rulRateRepository.getRulRateByCompanyID(companyId);
                LOGGER.info("getRulRateByCompanyID with companyId: {}, response: {}", companyId, GsonUtils.toJsonString(rulRates));

                List<Order> finalOrders = new ArrayList<>();
                rulRates.stream().forEach(model -> {
                    List<Order> orderByRulrate = orderRepository.getAllByRulID(model.getId());
                    finalOrders.addAll(orderByRulrate);
                });

                orders = finalOrders;
                LOGGER.info("getOrderByFilter with companyId: {}, response: {}", companyId, GsonUtils.toJsonString(orders));
            }

            orders.stream().forEach(model -> {
                OrderDTO orderDTO = new OrderDTO();
                orderDTO.doMappingEntity(model);
                orderDTOS.add(orderDTO);
            });

            LOGGER.info("getOrderByFilter: {}", GsonUtils.toJsonString(orderDTOS));

            response.success(SUCCESSFUL.getMessage(), orderDTOS);
        } catch (Exception ex) {
            LOGGER.info("getOrderByFilter exception: {}", ex);
            response.fail(ex.getMessage());
        }
        return response;
    }

    private Boolean producerOrderRequest(Order order) {
        try {
            Properties props = new Properties();
            props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "52.168.24.38:9092");
            props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
            props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
            String sender = new Gson().toJson(order);
            ProducerRecord<String, String> data = new ProducerRecord<String, String>("orderLog", 0, null, sender);
            producer.send(data);
            producer.close();

            LOGGER.info("producerOrderRequest successful : {}", GsonUtils.toJsonString(order));
            return true;
        } catch (Exception ex) {
            LOGGER.info("producerOrderRequest exception: {}", ex);
        }
        return false;
    }

    private List<SuggestionResponseDTO> processSuggestions(CMLocation senderLocation, CMLocation receiverLocation) {
        List<SuggestionResponseDTO> suggestionResponseDTOS = new ArrayList<>();
        try {
            CMRouting routing = routingRepository.getCMRoutingByFirstLastStep(senderLocation.getId(), receiverLocation.getId());
            LOGGER.info("routing: {}", GsonUtils.toJsonString(routing));

            List<RulRate> rulRates = rulRateRepository.getRulRateByRoutId(routing.getId());

            for (RulRate rulRate : rulRates) {
                SuggestionResponseDTO dto = new SuggestionResponseDTO();
                Company company = companyRepository.getCompanyById(rulRate.getCompanyID());

                List<RulsurCharge> rulsurCharges = rulsurChargeRepository.getRulsurChargeByRulRateID(rulRate.getId());
                List<SurchargeDTO> surchargeDTOS = new ArrayList<>();
                for (RulsurCharge rulsurCharge : rulsurCharges) {
                    SurchargeDTO surchargeDTO = new SurchargeDTO();
                    surchargeDTO.setAmount(rulsurCharge.getAmount());
                    surchargeDTO.setId(rulsurCharge.getSurID());

                    CMSurcharge surcharge = surchargeRepository.getCMSurchargeById(rulsurCharge.getSurID());
                    surchargeDTO.setSurCode(surcharge.getSurCode());
                    surchargeDTO.setSurName(surcharge.getSurName());

                    CMCurrency currency = currencyRepository.getCMCurrencyById(rulsurCharge.getCurrencyId());
                    surchargeDTO.setCurrencyName(currency.getCurName());
                    surchargeDTOS.add(surchargeDTO);
                }
                dto.doMappingEntityToDTO(rulRate, company, routing.getRoutTransitTime(), surchargeDTOS);
                suggestionResponseDTOS.add(dto);
            }
        } catch (Exception ex) {
            LOGGER.info("processSuggestions exception: {}", ex.getMessage());
        }
        return suggestionResponseDTOS;
    }

}
