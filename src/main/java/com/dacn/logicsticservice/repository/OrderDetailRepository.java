package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "select * from `orderdetail` where ID = ?1", nativeQuery = true)
    OrderDetail getAllById(Integer id);

    @Query(value = "select * from `orderdetail` where OrderID = ?1 and RulID = ?2", nativeQuery = true)
    OrderDetail getAllByOrderIDAndRulId(Integer orderID, Integer rulId);
}
