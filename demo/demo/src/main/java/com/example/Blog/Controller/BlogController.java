package com.example.Blog.Controller;

import com.example.Blog.Entity.Blog;
import com.example.Blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {
     @Autowired
     BlogService blogService;

     @PostMapping("write")
     public ResponseEntity<String> writeBlog(@RequestParam String title, @RequestParam String content,@RequestParam String username,@RequestParam String authorName) {
         return blogService.writeBlog(title,content,username,authorName);
     }

     @PutMapping("like")
     public ResponseEntity<String> likeBlog(@RequestParam String title,@RequestParam String username,@RequestParam String authorName) {
         return blogService.likeBlog(title,username,authorName);
     }

     @PutMapping("comment")
     public ResponseEntity<String> addComment(@RequestParam String title,@RequestParam String username,@RequestParam String authorName,@RequestParam String comment) {
         return blogService.addComment(title,username,authorName,comment);
     }

     @PutMapping("removeLike")
     public ResponseEntity<String> removeLike(@RequestParam String title,@RequestParam String username,@RequestParam String authorName) {
         return blogService.removeLike(title,username,authorName);
     }

     @GetMapping("getBlog")
     public ResponseEntity<Blog> getBlog(@RequestParam String title, @RequestParam String username, @RequestParam String authorName) {
         return blogService.getBlog(title,username,authorName);
     }

     @DeleteMapping("deleteBlog")
     public ResponseEntity<String> deleteBlog(@RequestParam String title, @RequestParam String username, @RequestParam String authorName) {
         return blogService.deleteBlog(title,username,authorName);
     }

     @DeleteMapping("deleteComment")
     public ResponseEntity<String> deleteComment(@RequestParam String title,@RequestParam String username,@RequestParam String authorName,@RequestParam String comment) {
         return blogService.deleteComment(title,username,authorName,comment);
     }

     @GetMapping("search")
     public ResponseEntity<List<Blog>> searchTopic(@RequestParam String topic){
         return blogService.searchTopic(topic);
     }
}
