package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMCurrency;
import com.dacn.logicsticservice.model.CMSurcharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CMCurrencyRepository extends JpaRepository<CMCurrency, Integer> {

    @Query(value = "select * from cmcurrency where Id = ?1", nativeQuery = true)
    CMCurrency getCMCurrencyById(int id);
}
