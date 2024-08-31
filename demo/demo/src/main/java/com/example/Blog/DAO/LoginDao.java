package com.example.Blog.DAO;

import com.example.Blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM User WHERE username = :username AND password = :password" ,nativeQuery = true)
    List<User> verify(@Param("username") String username,@Param("password") String password);

    @Query(value = "SELECT * FROM User WHERE username = :username",nativeQuery = true)
    List<User> deosExit(@Param("username") String username);
}
