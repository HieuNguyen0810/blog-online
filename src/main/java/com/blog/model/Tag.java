package com.blog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tag {
    @Id
    @Column(name = "tag_id")
    private Integer id;

    @Column(name = "tag_name", nullable = false)
    private String tagName;

    @ManyToMany
    @JoinTable(name = "tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "blog_id"))
    private Collection<Blog> blogs;
}
