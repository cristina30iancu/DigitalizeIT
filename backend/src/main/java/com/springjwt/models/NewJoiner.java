package com.springjwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewJoiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String lastName;
    @NotNull
    private String firstName;

    @NotNull
    private Date startDate;
    @NotNull
    private String project;
    @NotNull
    private Boolean done;
    @NotNull
    private Position position;

    @ManyToMany
    private List<JwtUser> jwtUsers;

    @OneToMany
    private List<Equipment_newJoiner> equipment_newJoiners;



}
