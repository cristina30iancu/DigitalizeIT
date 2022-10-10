package com.springjwt.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Equipment_newJoiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean done = false;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private NewJoiner newJoiner;

}
