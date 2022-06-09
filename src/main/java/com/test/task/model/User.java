package com.test.task.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "password")
    private String password;

//    @OneToMany
//    @JoinColumn(name = "id",referencedColumnName = "quote_id")
//    private List<Quotes> quotes;
}
