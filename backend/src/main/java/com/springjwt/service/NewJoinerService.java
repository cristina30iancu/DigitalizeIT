package com.springjwt.service;

import com.springjwt.models.ERole;
import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewJoinerService {
    private final NewJoinerRepository newJoinerRepository;
    private final UserService userService;

    public NewJoiner saveNewJoiner(NewJoiner newJoiner) {
        return newJoinerRepository.save(newJoiner);
    }
    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public List<NewJoiner> getNewJoinerListByRole() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();


        System.out.println((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        JwtUser currentlyAuthenticated = userService.getUserByEmail((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        //GrantedAuthority user = users.hasNext()? users.next() : null;

        // method for getting first and only item of a given collection
        Iterator<GrantedAuthority> itr = authorities.iterator();
        GrantedAuthority authority = itr.hasNext()? itr.next() : null;

        List<NewJoiner> allNewJoiners = getAllNewJoiners();
        List<NewJoiner> toReturn;

        if(authority.getAuthority().equals(ERole.ROLE_IT_SUPPORT.name())) {
            toReturn = allNewJoiners.stream().filter(n -> n.getDone() == false).collect(Collectors.toList());
        }
        else {
            toReturn = currentlyAuthenticated.getNewJoiners().stream().filter(n -> n.getDone() == false).collect(Collectors.toList());
        }

        return toReturn;
    }
}
