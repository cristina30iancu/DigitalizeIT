package com.dbcs.digitalizeit.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EmployeeRole name;

    public Role() {

    }

    public Role(EmployeeRole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeRole getName() {
        return name;
    }

    public void setName(EmployeeRole name) {
        this.name = name;
    }
}