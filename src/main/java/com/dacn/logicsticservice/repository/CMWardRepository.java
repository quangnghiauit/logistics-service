package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMWard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMWardRepository extends JpaRepository<CMWard, Integer> {

    @Query(value = "select * from cmward as w where w.DistrictId = ?1", nativeQuery = true)
    List<CMWard> getCMWardByDistrictId(String districtId);
}
