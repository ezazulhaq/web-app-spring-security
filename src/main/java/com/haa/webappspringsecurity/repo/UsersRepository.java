package com.haa.webappspringsecurity.repo;

import com.haa.webappspringsecurity.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    @Query(value = "select * from users where username = ?1", nativeQuery = true)
    Users findByUserName(String username);

}
