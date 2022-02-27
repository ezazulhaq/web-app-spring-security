package com.haa.webappspringsecurity.doa;

import com.haa.webappspringsecurity.entity.Users;

public interface UsersDAO {

    Users findByUserName(String username);

}
