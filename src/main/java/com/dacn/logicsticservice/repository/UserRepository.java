package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "select * from users as u where u.userName in (?1)", nativeQuery = true)
    List<User> findAllByListUserName(List<String> userName);
}
