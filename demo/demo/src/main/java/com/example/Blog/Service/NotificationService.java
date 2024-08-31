package com.example.Blog.Service;

import com.example.Blog.DAO.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;

    public ResponseEntity<String> sendNotification() {
        try{
            int id = (int) (Math.random() * 11);
            String notification = notificationDao.getNotification(id);
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
