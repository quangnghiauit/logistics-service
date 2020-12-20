package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users, Integer> {

//    @Query(value = "select * from users", nativeQuery = true)
//    List<Users> getAllCustomer();

    @Query(value = "select * from users where ID = ?1", nativeQuery = true)
    Users getUserByID(int id);

    @Query(value = "select * from users where UserName = ?1 and Password = ?2", nativeQuery = true)
    Users getUserVerifyLogin(String username, String password);

    @Query(value = "select * from users where UserName = ?1", nativeQuery = true)
    Users getUserByUserName(String username);
}
