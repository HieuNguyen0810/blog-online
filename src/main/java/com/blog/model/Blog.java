package com.blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Blog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private Double rate;

    private Integer numOfLikes;

    private Integer numOfViews;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    @CreationTimestamp
    private Date createdTime;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "blog_tag", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<Tag> tags;

    @OneToMany(mappedBy = "blog")
    private Collection<Comment> comments;

    @OneToMany(mappedBy = "blog")
    private Collection<Vote> votes;
}
