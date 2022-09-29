package com.springjwt.controllers;

import com.springjwt.models.ERole;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  public String userAccess() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    if(authentication.getAuthorities().stream()
            .filter(a-> a.getAuthority().equals(ERole.MANAGER.name())).count() ==1)
   return "Succes for MANAGER";
   else return "User unauthorized";
  }

  @GetMapping("/mod")
  public String moderatorAccess() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    if(authentication.getAuthorities().stream()
            .filter(a-> a.getAuthority().equals(ERole.IT_SUPPORT.name())).count() ==1)
      return "Succes for IT_SUPPORT";
    else return "User unauthorized";
  }

}
