package com.springjwt.service;

import com.springjwt.models.JwtUser;
import com.springjwt.repository.UserRepository;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public JwtUser save(JwtUser jwtUser){
        return userRepository.save(jwtUser);
    }

    public Optional<JwtUser> findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public JwtUser getUserByEmail(String email){
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found by email!"));
    }

    public JwtUser getUserByUsername(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(()-> new EntityNotFoundException("User not found by username!"));
    }

    public List<JwtUser> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserById(Long userId){userRepository.deleteById(userId);}
}
