package com.example.Blog.Service;

import com.example.Blog.DAO.LoginDao;
import com.example.Blog.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginDao loginDao;

    public ResponseEntity<String> login(String username, String password) {
        try{
            List<User> list = loginDao.verify(username,password);
            if (list.isEmpty()){
                return new ResponseEntity<>("Invalid Credentials", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("User Verified", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> signIn(String username, String password) {
        try{
            List<User> list = loginDao.deosExit(username);
            if (!list.isEmpty()){
                return new ResponseEntity<>("User Exist Already", HttpStatus.BAD_REQUEST);
            }
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser = loginDao.save(newUser);
            return new ResponseEntity<>("Sign In Successful", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteUser(String username) {
        try{
            List<User> list = loginDao.deosExit(username);
            if (list.isEmpty()){
                return new ResponseEntity<>("User Deosn't Exist", HttpStatus.BAD_REQUEST);
            }
            loginDao.delete(list.get(0));
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> forgetPassword(String username) {
        try {
            List<User> list = loginDao.deosExit(username);
            if (list.isEmpty()){
                return new ResponseEntity<>("User Doesn't Exist", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(list.get(0).getPassword(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.BAD_REQUEST);
        }
    }
}
