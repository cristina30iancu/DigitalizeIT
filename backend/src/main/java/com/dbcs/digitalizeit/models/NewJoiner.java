package com.dbcs.digitalizeit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewJoiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String last_name;
    private String first_name;

    @ManyToOne
    private Position position;

    private Date startDate;
    private String project;
    private Boolean done;

    @ManyToMany
    private List<User> users;

}
