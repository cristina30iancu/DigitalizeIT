package com.springjwt.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Equipment_newJoiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean done = false;

    @ManyToOne
    private Equipment equipment;

    @ManyToOne
    private NewJoiner newJoiner;

    public Equipment_newJoiner(boolean done, Equipment equipment, NewJoiner newJoiner) {
        this.done = done;
        this.equipment = equipment;
        this.newJoiner = newJoiner;
    }

    public Equipment_newJoiner() {
        this.done = false;
    }
}
