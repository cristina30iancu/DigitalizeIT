package com.springjwt.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data

@Table(name = "users", 
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email") 
    })
@NoArgsConstructor
@AllArgsConstructor
public class JwtUser implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Size(max = 20)
  private String lastName;

  @NotNull
  @Size(max = 20)
  private String firstName;

  @NotNull
  @Size(max = 50)
  @Email
  private String email;

  @NotNull
  @Size(max = 50)
  private String username;

  @NotNull
  @Size(max = 120)
  private String password;

  @NotNull
  @Enumerated(EnumType.STRING)
  @ElementCollection(fetch = FetchType.EAGER)
  private Set<ERole> userType = new HashSet<>();

  @ManyToMany
  private List<NewJoiner> newJoiners;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<GrantedAuthority> authorities = new HashSet<>();
    for (ERole r : this.userType) {
      SimpleGrantedAuthority sga = new SimpleGrantedAuthority(r.name());
      authorities.add(sga);
    }
    return authorities;
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

//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(  name = "user_roles",
//        joinColumns = @JoinColumn(name = "user_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id"))
//  private Set<Role> roles = new HashSet<>();


}
