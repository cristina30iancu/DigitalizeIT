package com.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 20)
  private String last_name;

  @NotBlank
  @Size(max = 20)
  private String first_name;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 50)
  private String username;

  @NotBlank
  @Size(max = 120)
  private String password;

  @Column
  private ERole user_type;

  @ManyToMany
  private List<NewJoiner> new_joiners;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority(this.user_type.name()));
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
    return false;
  }

//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(  name = "user_roles",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
//  private Set<Role> roles = new HashSet<>();

//  public User() {
//  }
//
//  public User(String username, String email, String password) {
//    this.username = username;
//    this.email = email;
//    this.password = password;
//  }

//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//
//  public Set<Role> getRoles() {
//    return roles;
//  }
//
//  public void setRoles(Set<Role> roles) {
//    this.roles = roles;
//  }
}
