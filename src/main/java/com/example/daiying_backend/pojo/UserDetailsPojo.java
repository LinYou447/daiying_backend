package com.example.daiying_backend.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsPojo implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorities;

    public UserDetailsPojo(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        List<String> roles = Arrays.stream(user.getRole().split(",")).toList();
        this.authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
