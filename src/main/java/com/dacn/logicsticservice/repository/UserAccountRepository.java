package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    @Query(value = "select * from useraccount where ID = ?1", nativeQuery = true)
    UserAccount getUserByID(int id);

    @Query(value = "select * from useraccount where Type = ?1 and userID = ?2", nativeQuery = true)
    UserAccount getUserAccountByTypeAndUserId(int type, int userId);
}
