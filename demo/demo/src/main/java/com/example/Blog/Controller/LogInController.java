package com.example.Blog.Controller;

import com.example.Blog.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LogInController {

    @Autowired
    LoginService loginService;

    @GetMapping("verify")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password) {
        return loginService.login(username,password);
    }

    @PostMapping("new")
    public ResponseEntity<String> signIn(@RequestParam String username,@RequestParam String password) {
        return loginService.signIn(username,password);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteUser(@RequestParam String username) {
        return loginService.deleteUser(username);
    }

    @GetMapping("get")
    public ResponseEntity<String> forgetPassword(@RequestParam String username) {
        return loginService.forgetPassword(username);
    }

}
