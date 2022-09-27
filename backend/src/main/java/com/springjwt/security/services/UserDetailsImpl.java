package com.springjwt.security.services;

import com.springjwt.models.ERole;
import com.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String email;

  private String last_name;

  @JsonIgnore
  private String password;

  private ERole user_type;

  public UserDetailsImpl(Long id, String email, String last_name, String password,
                         ERole eRole) {
    this.id = id;
    this.email = email;
    this.last_name = last_name;
    this.password = password;
    this.user_type = eRole;
  }

  public static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(
        user.getId(),
            user.getEmail(),
        user.getLast_name(),
        user.getPassword(), 
        user.getUser_type());
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(user_type).stream().map(role -> new SimpleGrantedAuthority(role.name()))
            .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return last_name;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
