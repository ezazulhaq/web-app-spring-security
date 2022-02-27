package com.haa.webappspringsecurity.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "enabled")
    @NotNull
    private Boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Roles> userRole = new HashSet<>();

    public Users() {
    }

    public Users(@NotNull String username, @NotNull String password, @NotNull Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Users [enabled=" + enabled + ", password=" + password + ", username=" + username + "]";
    }

    public Set<Roles> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Roles> userRole) {
        this.userRole = userRole;
    }

}
