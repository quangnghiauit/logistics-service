package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "select * from `orders` where ID = ?1", nativeQuery = true)
    Order getAllById(Integer id);

    @Query(value = "select * from `orders` where CusID = ?1 order by ID desc", nativeQuery = true)
    List<Order> getAllByCusId(Integer cusId);

    @Query(value = "select * from `orders` where RulID = ?1 order by ID desc", nativeQuery = true)
    List<Order> getAllByRulID(Integer rulId);
}
