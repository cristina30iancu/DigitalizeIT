package com.springjwt.service;

import com.springjwt.models.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    // Aici am facut in asa fel incat sa se paote face login cu email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JwtUser jwtUser = userService.getUserByEmail(email);
        return new User(jwtUser.getUsername(), jwtUser.getPassword(), jwtUser.isEnabled(), true, true, true, jwtUser.getAuthorities());
    }

//    @Override
//    public UserDetails loadUserByEmail(String email) throws
}
