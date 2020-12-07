package com.dacn.logicsticservice.service;

import com.dacn.logicsticservice.dto.address.CMDistrictDTO;
import com.dacn.logicsticservice.dto.address.CMProvinceDTO;
import com.dacn.logicsticservice.dto.address.CMWardDTO;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;

public interface AddressManagementService {

    BaseResponseDTO<CMProvinceDTO> getAllCMProvince();

    BaseResponseDTO<CMDistrictDTO> getAllDistrict();

    BaseResponseDTO<CMDistrictDTO> getDistrictByProvinceId(String providerId);

    BaseResponseDTO<CMWardDTO> getAllWard();

    BaseResponseDTO<CMWardDTO> getWardByDistrictId(String districtId);
}
