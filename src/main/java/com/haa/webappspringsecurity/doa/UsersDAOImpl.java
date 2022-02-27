package com.haa.webappspringsecurity.doa;

import com.haa.webappspringsecurity.entity.Users;
import com.haa.webappspringsecurity.repo.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users findByUserName(String username) {
        return usersRepository.findByUserName(username);
    }

}
