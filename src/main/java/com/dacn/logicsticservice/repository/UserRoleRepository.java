package com.dacn.logicsticservice.repository;

import com.dacn.logicsticservice.model.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

    @Query(value = "select * from user_role as u where u.role = 'CLIENT'", nativeQuery = true)
    List<UserRole> findUserNameByRoleClient();
}
