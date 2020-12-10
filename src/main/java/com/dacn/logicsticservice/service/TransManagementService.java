package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.request.OrderRequest;
import com.dacn.logicsticservice.dto.request.SuggestRequest;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.dto.trans.CompanyDTO;
import com.dacn.logicsticservice.dto.trans.CustomerDTO;
import com.dacn.logicsticservice.dto.trans.SuggestionResponseDTO;

public interface TransManagementService {

    BaseResponseDTO<CompanyDTO> getAllCompany();

    BaseResponseDTO<CustomerDTO> getAllCustomer();

    BaseResponseDTO<SuggestionResponseDTO> getAllSuggestions(SuggestRequest suggestRequest);

    BaseResponseDTO createOrder(OrderRequest request);
}
