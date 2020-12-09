package com.dacn.logicsticservice.service.impl;

import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.dto.trans.CompanyDTO;
import com.dacn.logicsticservice.dto.trans.CustomerDTO;
import com.dacn.logicsticservice.dto.trans.SuggestionResponseDTO;
import com.dacn.logicsticservice.dto.trans.SurchargeDTO;
import com.dacn.logicsticservice.model.*;
import com.dacn.logicsticservice.repository.*;
import com.dacn.logicsticservice.service.TransManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;


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

    @Autowired
    public TransManagementServiceImpl(CompanyRepository companyRepository,
                                      CustomerRepository customerRepository,
                                      CMLocationRepository locationRepository,
                                      CMRoutingRepository routingRepository,
                                      CMRulRateRepository rulRateRepository,
                                      CMContainerRepository containerRepository,
                                      RulsurChargeRepository rulsurChargeRepository,
                                      CMSurchargeRepository surchargeRepository,
                                      CMCurrencyRepository currencyRepository) {

        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
        this.locationRepository = locationRepository;
        this.routingRepository = routingRepository;
        this.rulRateRepository = rulRateRepository;
        this.containerRepository = containerRepository;
        this.rulsurChargeRepository = rulsurChargeRepository;
        this.surchargeRepository = surchargeRepository;
        this.currencyRepository = currencyRepository;
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

        CMLocation receiverLocation = locationRepository.getCMLocationByCondition(wardIdReceiver, districtIdReceiver,
                provinceIdReceiver, locDescriptionReceiver);

        return processSuggestions(senderLocation, receiverLocation);
    }

    private BaseResponseDTO<SuggestionResponseDTO> processSuggestions(CMLocation senderLocation, CMLocation receiverLocation) {
        BaseResponseDTO<SuggestionResponseDTO> result = new BaseResponseDTO<>();
        List<SuggestionResponseDTO> suggestionResponseDTOS = new ArrayList<>();
        CMRouting routing = routingRepository.getCMRoutingByFirstLastStep(senderLocation.getId(), receiverLocation.getId());
        List<RulRate> rulRates = rulRateRepository.getRulRateByRoutId(routing.getId());


        for (RulRate rulRate : rulRates) {
            SuggestionResponseDTO dto = new SuggestionResponseDTO();
            Company company = companyRepository.getCompanyById(rulRate.getCompanyID());

            List<RulsurCharge> rulsurCharges = rulsurChargeRepository.getRulsurChargeById(rulRate.getId());
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
        result.success(SUCCESSFUL.getMessage(), suggestionResponseDTOS);
        return result;

    }

}
