package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMProvince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMProvinceRepository extends JpaRepository<CMProvince, Integer> {

    @Query(value = "select * from cmprovince as p", nativeQuery = true)
    List<CMProvince> findAllProvinces();
}
