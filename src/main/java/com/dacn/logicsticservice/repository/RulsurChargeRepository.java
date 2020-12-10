package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.RulsurCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RulsurChargeRepository extends JpaRepository<RulsurCharge, Integer> {

    List<RulsurCharge> getRulsurChargeByRulRateID(int ruleRateID);
}
