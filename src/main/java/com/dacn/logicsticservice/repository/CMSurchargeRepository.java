package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMSurcharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMSurchargeRepository extends JpaRepository<CMSurcharge, Integer> {

    @Query(value = "select * from cmsurcharge where ID = ?1", nativeQuery = true)
    CMSurcharge getCMSurchargeById(int id);
}
