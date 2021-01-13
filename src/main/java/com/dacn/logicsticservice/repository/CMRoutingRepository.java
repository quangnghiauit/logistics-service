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

    @Query(value = "select * from cmrouting where RoutFirstStep = ?1", nativeQuery = true)
    List<CMRouting> getCMRoutingByRoutAndRoutFirstStep(int routFirstStep);

    @Query(value = "select * from cmrouting where RoutLastStep = ?1", nativeQuery = true)
    List<CMRouting> getCMRoutingByRoutAndRoutLastStep(int routLastStep);

    @Query(value = "select * from cmrouting", nativeQuery = true)
    List<CMRouting> getAllRouting();
}
