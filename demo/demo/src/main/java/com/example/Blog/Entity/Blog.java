package com.example.Blog.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String title;
    private String content;
    private String author;
    private Integer likes;
    @ElementCollection
    @CollectionTable(name = "blog_comments",
            joinColumns = @JoinColumn(name = "blog_id"))
    @Column(name = "comment")
    private List<String> comments = new ArrayList<>();

}
