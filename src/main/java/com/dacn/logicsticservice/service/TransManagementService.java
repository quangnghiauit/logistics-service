package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.dto.trans.CompanyDTO;
import com.dacn.logicsticservice.dto.trans.CustomerDTO;

public interface TransManagementService {

    BaseResponseDTO<CompanyDTO> getAllCompany();

    BaseResponseDTO<CustomerDTO> getAllCustomer();
}
