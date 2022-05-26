package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    @javax.validation.constraints.NotEmpty(message = "Please provide your first name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @javax.validation.constraints.NotEmpty(message = "Please provide your last name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    @Length(min = 5, message = "Your password must have at least 5 characters")
    @javax.validation.constraints.NotEmpty(message = "Please provide your password")
    //@JsonIgnore
    private String password;

    @Column(nullable = false)
    private int role;

    @Column(unique = true, nullable = false)
    @javax.validation.constraints.Email(message = "Please provide a valid Email")
    @javax.validation.constraints.NotEmpty(message = "Please provide your password")
    private String email;

    private String phoneNumber;

    private Boolean gender;

    private Date dob;

    @OneToMany(mappedBy = "user")
    private Collection<Blog> blogs;

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "user")
    private Collection<Vote> votes;
}
