package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CMStatusRepository extends JpaRepository<CMStatus, Integer> {

    @Query(value = "select * from cmstatus", nativeQuery = true)
    List<CMStatus> getAll();

    @Query(value = "select * from cmstatus where Id = ?1", nativeQuery = true)
    CMStatus getCMStatusById(int id);
}
