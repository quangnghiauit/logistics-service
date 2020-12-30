package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMLocationRepository extends JpaRepository<CMLocation, Integer> {

    @Query(value = "select * from cmlocation as l where l.WardId = ?1 and l.DistrictId = ?2 " +
            "and l.ProvinceId = ?3 and l.LocDescription like %?4%", nativeQuery = true)
    CMLocation getCMLocationByCondition(String wardId, String districtId, String provinceId, String locDescription);

    @Query(value = "select * from cmlocation where ID = ?1", nativeQuery = true)
    CMLocation getCMLocationById(int id);
}
