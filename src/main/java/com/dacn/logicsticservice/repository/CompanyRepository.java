package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.Company;
import com.dacn.logicsticservice.model.RulRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "select * from company", nativeQuery = true)
    List<Company> getAllCompany();

    @Query(value = "select * from company where ID = ?1", nativeQuery = true)
    Company getCompanyById(int id);
}
