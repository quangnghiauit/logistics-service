package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer", nativeQuery = true)
    List<Customer> getAllCustomer();

    @Query(value = "select * from customer where ID = ?1", nativeQuery = true)
    Customer getCustomerByID(int id);
}
