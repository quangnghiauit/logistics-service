package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.dto.trans.CompanyDTO;
import com.dacn.logicsticservice.dto.trans.CustomerDTO;
import com.dacn.logicsticservice.dto.trans.SuggestionDetailDTO;

import java.util.Map;

public interface TransManagementService {

    BaseResponseDTO<CompanyDTO> getAllCompany();

    BaseResponseDTO<CustomerDTO> getAllCustomer();

    BaseResponseDTO getAllSuggestions(SuggestRequest suggestRequest);

    BaseResponseDTO createOrder(OrderRequest request);

    BaseResponseDTO getOrderByOrderId(Integer orderId);

    BaseResponseDTO getOrderByCustomerId(Integer customerId);

    BaseResponseDTO getOrderByCompanyId(Integer companyId);

    Map<Integer, String> getMapStatus();

    BaseResponseDTO updateStatusOrder(Integer orderId, Integer rulrateId, Integer status);
}
