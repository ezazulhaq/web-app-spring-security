package com.haa.webappspringsecurity.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.haa.webappspringsecurity.doa.UsersDAOImpl;
import com.haa.webappspringsecurity.entity.Roles;
import com.haa.webappspringsecurity.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersDAOImpl userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.findByUserName(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(Users user,
            List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.getEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Roles> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        // Build user's authorities
        for (Roles userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getAuthority()));
        }

        return new ArrayList<>(setAuths);

        // return result;
    }

}
