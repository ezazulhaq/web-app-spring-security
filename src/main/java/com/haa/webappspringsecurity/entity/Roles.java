package com.haa.webappspringsecurity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(columnNames = { "username", "authority" }))
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_roles_id")
    private Integer userRolesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Users user;

    @Column(name = "authority")
    @NotNull
    private String authority;

    public Roles() {
    }

    public Roles(@NotNull Users user, @NotNull String authority) {
        this.user = user;
        this.authority = authority;
    }

    public Integer getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(Integer userRolesId) {
        this.userRolesId = userRolesId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Roles [authority=" + authority + ", user=" + user + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authority == null) ? 0 : authority.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((userRolesId == null) ? 0 : userRolesId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Roles other = (Roles) obj;
        if (authority == null) {
            if (other.authority != null)
                return false;
        } else if (!authority.equals(other.authority))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        if (userRolesId == null) {
            if (other.userRolesId != null)
                return false;
        } else if (!userRolesId.equals(other.userRolesId))
            return false;
        return true;
    }

}
