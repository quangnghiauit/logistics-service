package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.OrderFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFeatureRepository extends JpaRepository<OrderFeature, Integer> {

    @Query(value = "select * from orderfeature where id = ?1", nativeQuery = true)
    OrderFeature getOrderFeatureById(int id);
}
