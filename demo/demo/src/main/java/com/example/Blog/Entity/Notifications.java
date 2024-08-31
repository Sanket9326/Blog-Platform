package com.example.Blog.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
public class Notifications {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    private String notification;
}
