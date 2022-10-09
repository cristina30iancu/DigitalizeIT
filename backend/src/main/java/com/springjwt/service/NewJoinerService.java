package com.springjwt.service;

import com.springjwt.models.ERole;
import com.springjwt.models.JwtUser;
import com.springjwt.models.NewJoiner;
import com.springjwt.repository.NewJoinerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
        JwtUser manager = getCurrentUser();
        manager.addNewJoiner(newJoiner);
        return newJoinerRepository.save(newJoiner);
    }
    public NewJoiner findAllByName(String first, String last) {
        return newJoinerRepository.findAllByFirstNameAndLastName(first, last);
    }

    public JwtUser getCurrentUser() {
        return userService.getUserByEmail((String)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
    public List<NewJoiner> getNewJoinerListByRole() {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        JwtUser currentlyAuthenticated = getCurrentUser();
        Iterator<GrantedAuthority> itr = authorities.iterator();
        GrantedAuthority authority = itr.hasNext()? itr.next() : null;
        List<NewJoiner> allNewJoiners = getAllNewJoiners();
        if(authority.getAuthority().equals(ERole.ROLE_IT_SUPPORT.name())) {
            return allNewJoiners.stream().filter(n -> n.getDone() == false).collect(Collectors.toList());
        }
        else {
            return currentlyAuthenticated.getNewJoiners().stream().filter(n -> n.getDone() == false).collect(Collectors.toList());
        }
    }
    public List<NewJoiner> getAllNewJoiners() {
        return newJoinerRepository.findAll();
    }

    public List<NewJoiner> getUserByFirst(String first) {
        return newJoinerRepository.findAllByFirstName(first);
    }

    public List<NewJoiner> getUserByLast(String last) {
        return newJoinerRepository.findAllByLastName(last);
    }

    public List<NewJoiner> findUsersByProject(String projectName) {
        return newJoinerRepository.findNewJoinersByProject(projectName);
    }

    public void setAsDone(Long newJoinerId){
        newJoinerRepository.findById(newJoinerId).get().setDone(true);
    }
}
