package com.example.Blog.Controller;

import com.example.Blog.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notify")
public class NotificationController {

    @Autowired
    public NotificationService notificationService;

    @GetMapping("getNotify")
    public ResponseEntity<String> sendNotification() {
        return  notificationService.sendNotification();
    }
}
