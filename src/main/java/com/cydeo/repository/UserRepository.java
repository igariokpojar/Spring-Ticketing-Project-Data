package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username); // select * from user where is_deleted = false

    @Transactional // this annotation is for DERIVED QUERY , if we are using @Modifying we must use JPQL and NATIVE QUERY
   void deleteByUserName(String username); // these are derived queried

    List<User> findByRoleDescriptionIgnoreCase(String description);
}
