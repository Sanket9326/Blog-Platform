package com.example.Blog.DAO;

import com.example.Blog.Entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationDao extends JpaRepository<Notifications,Integer> {

    @Query(value = "Select notification FROM Notifications where id = :id",nativeQuery = true)
    String getNotification(@Param("id") int id);
}
