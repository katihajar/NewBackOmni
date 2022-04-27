package com.example.omnicons.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Entity
public class User implements UserDetails {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long iduser;
        private String nomUser;
        private String username;
        private String password;
        private String prenomUser;
        private String emailUser;
        protected String role;
    @ManyToOne
        private Profile profile;
        @ManyToMany(fetch = FetchType.EAGER)
        private Collection<Role> authorities;
        private boolean accountNonExpired=true;
        private boolean accountNonLocked=true;
        private boolean credentialsNonExpired=true;
        private boolean enabled=true;

        public User(String username, String password ) {
            this.password = password;
            this.username = username;
        }

        public User() {
        }


        @Override
        public Collection<Role> getAuthorities() {
            return authorities;
        }

        public void setAuthorities(Collection<Role> authorities) {
            this.authorities = authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
        }

        @Override
        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}



