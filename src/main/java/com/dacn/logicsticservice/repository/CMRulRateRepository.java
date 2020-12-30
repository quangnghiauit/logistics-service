package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.RulRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMRulRateRepository extends JpaRepository<RulRate, Integer> {

    @Query(value = "select * from rulrate as r where r.RoutID = ?1", nativeQuery = true)
    List<RulRate> getRulRateByRoutId(String routId);

    @Query(value = "select * from rulrate as r where r.CompanyID = ?1", nativeQuery = true)
    List<RulRate> getRulRateByCompanyID(Integer companyID);

    @Query(value = "select * from rulrate as r where r.ID = ?1", nativeQuery = true)
    RulRate getRulRateById(int id);
}
