package com.dacn.logicsticservice.service.impl;

import com.dacn.logicsticservice.dto.address.CMDistrictDTO;
import com.dacn.logicsticservice.dto.address.CMProvinceDTO;
import com.dacn.logicsticservice.dto.address.CMWardDTO;
import com.dacn.logicsticservice.dto.response.BaseResponseDTO;
import com.dacn.logicsticservice.model.CMDistrict;
import com.dacn.logicsticservice.model.CMProvince;
import com.dacn.logicsticservice.model.CMWard;
import com.dacn.logicsticservice.repository.CMDistrictRepository;
import com.dacn.logicsticservice.repository.CMProvinceRepository;
import com.dacn.logicsticservice.repository.CMWardRepository;
import com.dacn.logicsticservice.service.AddressManagementService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.dacn.logicsticservice.enumeration.ReturnCodeEnum.SUCCESSFUL;

@Service
public class AddressManagementServiceImpl implements AddressManagementService {

    private static Logger LOGGER = LoggerFactory.getLogger(AddressManagementServiceImpl.class);

    private final CMDistrictRepository cmDistrictRepository;
    private final CMProvinceRepository cmProvinceRepository;
    private final CMWardRepository cmWardRepository;

    @Autowired
    public AddressManagementServiceImpl(CMDistrictRepository cmDistrictRepository,
                                        CMProvinceRepository cmProvinceRepository,
                                        CMWardRepository cmWardRepository) {

        this.cmProvinceRepository = cmProvinceRepository;
        this.cmDistrictRepository = cmDistrictRepository;
        this.cmWardRepository = cmWardRepository;
    }

    @Override
    public BaseResponseDTO<CMProvinceDTO> getAllCMProvince() {
        BaseResponseDTO<CMProvinceDTO> response = new BaseResponseDTO<>();
        List<CMProvinceDTO> cmProvinceDTOS = new ArrayList<>();

        try {
            List<CMProvince> cmProvinces = cmProvinceRepository.findAllProvinces();
            cmProvinces.stream().forEach(entity -> {
                CMProvinceDTO provinceDTO = new CMProvinceDTO();
                provinceDTO.mappingEntityToDTO(entity);
                cmProvinceDTOS.add(provinceDTO);
            });

            response.success(SUCCESSFUL.getMessage(), cmProvinceDTOS);
        } catch (Exception e) {
            LOGGER.info("getAllCMProvince exception: {}", e);
            response.fail(e.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO<CMDistrictDTO> getDistrictByProvinceId(String providerId) {
        BaseResponseDTO<CMDistrictDTO> response = new BaseResponseDTO<>();
        List<CMDistrictDTO> districtDTOS = new ArrayList<>();

        try {
            if (StringUtils.isNotBlank(providerId)) {
                List<CMDistrict> cmDistricts = cmDistrictRepository.getCMDistrictByProvinceId(providerId);
                cmDistricts.stream().forEach(entity -> {
                    CMDistrictDTO districtDTO = new CMDistrictDTO();
                    districtDTO.mappingEntityToDTO(entity);
                    districtDTOS.add(districtDTO);
                });
            }


            response.success(SUCCESSFUL.getMessage(), districtDTOS);
        } catch (Exception e) {
            LOGGER.info("getDistrictByProvinceId - providerId: {}, exception: {}", providerId, e);
            response.fail(e.getMessage());
        }
        return response;
    }

    @Override
    public BaseResponseDTO<CMWardDTO> getWardByDistrictId(String districtId) {
        BaseResponseDTO<CMWardDTO> response = new BaseResponseDTO<>();
        List<CMWardDTO> wardDTOS = new ArrayList<>();

        try {
            if (StringUtils.isNotBlank(districtId)) {
                List<CMWard> cmWards = cmWardRepository.getCMWardByDistrictId(districtId);
                cmWards.stream().forEach(entity -> {
                    CMWardDTO wardDTO = new CMWardDTO();
                    wardDTO.mappingEntityToDTO(entity);
                    wardDTOS.add(wardDTO);
                });
            }


            response.success(SUCCESSFUL.getMessage(), wardDTOS);
        } catch (Exception e) {
            LOGGER.info("getWardByDistrictId - districtId: {}, exception: {}", districtId, e);
            response.fail(e.getMessage());
        }
        return response;
    }
}
