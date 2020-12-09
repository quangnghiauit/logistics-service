package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.CMContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CMContainerRepository extends JpaRepository<CMContainer, Integer> {

    @Query(value = "select * from cmcontainer where ID = ?1", nativeQuery = true)
    List<CMContainer> getCMContainerById(String id);
}
