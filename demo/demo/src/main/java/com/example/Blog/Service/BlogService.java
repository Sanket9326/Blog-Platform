package com.example.Blog.Service;

import com.example.Blog.DAO.BlogDAO;
import com.example.Blog.Entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    BlogDAO blogDAO;

    public ResponseEntity<String> writeBlog(String title, String content, String username, String authorName) {
        try{
            Blog newBlog = new Blog();
            newBlog.setTitle(title);
            newBlog.setContent(content);
            newBlog.setUsername(username);
            newBlog.setAuthor(authorName);
            newBlog.setLikes(0);
            blogDAO.save(newBlog);
            return new ResponseEntity<>("Blog Added Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> likeBlog(String title, String username, String authorName) {
        try{
          blogDAO.likeBlog(title,username,authorName);
          return new ResponseEntity<>("Blog Liked Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addComment(String title, String username, String authorName, String comment) {
        try{
           List<Blog> curr = blogDAO.findBlog(title,username,authorName);
           curr.get(0).getComments().add(comment);
           blogDAO.save(curr.get(0));
           return new ResponseEntity<>("Comment Added Successfully", HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> removeLike(String title, String username, String authorName) {
        try{
            blogDAO.removeLike(title,username,authorName);
            return new ResponseEntity<>("Liked Removed Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Blog> getBlog(String title, String username, String authorName) {
        try {
            List<Blog> curr = blogDAO.findBlog(title,username,authorName);
            return new ResponseEntity<>(curr.get(0), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteBlog(String title, String username, String authorName) {
        try{
            blogDAO.deleteBlog(title,username,authorName);
            return new ResponseEntity<>("Blog Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteComment(String title, String username, String authorName, String comment) {
        try{
            blogDAO.deleteComment(title,username,authorName,comment);
            return new ResponseEntity<>("Comment Deleted Successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Blog>> searchTopic(String topic) {
        try{
            List<Blog> allBlogs = blogDAO.returnAllBlogs();
            List<Blog> toReturn = new ArrayList<>();
            for(Blog blog : allBlogs){
                if(blog.getTitle().contains(topic)){
                    toReturn.add(blog);
                }
            }
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
