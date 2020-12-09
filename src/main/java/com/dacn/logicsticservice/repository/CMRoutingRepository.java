package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMRouting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMRoutingRepository extends JpaRepository<CMRouting, Integer> {

    @Query(value = "select * from cmrouting as r where r.RoutFirstStep = ?1 and r.RoutLastStep = ?2", nativeQuery = true)
    CMRouting getCMRoutingByFirstLastStep(int routFirstStep, int routLastStep);
}
