package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMDistrictRepository extends JpaRepository<CMDistrict, Integer> {

    @Query(value = "select * from cmdistrict", nativeQuery = true)
    List<CMDistrict> getAllDistrict();

    @Query(value = "select * from cmdistrict as d where d.ProvinceId = ?1", nativeQuery = true)
    List<CMDistrict> getCMDistrictByProvinceId(String providerId);
}
