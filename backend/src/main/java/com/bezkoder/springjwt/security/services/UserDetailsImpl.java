package com.bezkoder.springjwt.security.services;

import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String last_name;

  private String email;

  @JsonIgnore
  private String password;

  private ERole user_type;

  public UserDetailsImpl(Long id, String last_name, String email, String password,
                         ERole eRole) {
    this.id = id;
    this.last_name = last_name;
    this.email = email;
    this.password = password;
    this.user_type = eRole;
  }

  public static UserDetailsImpl build(User user) {
    return new UserDetailsImpl(
        user.getId(), 
        user.getLast_name(),
        user.getEmail(),
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
