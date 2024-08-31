package com.example.Blog.DAO;

import com.example.Blog.Entity.Blog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDAO extends JpaRepository<Blog, Integer> {
    @Modifying
    @Transactional
    @Query(value = "Update Blog SET likes = likes+1 WHERE title = :tittle AND username = :username AND author = :authorName",nativeQuery = true)
    void likeBlog(@Param("tittle") String title,@Param("username") String username,@Param("authorName") String authorName);

    @Query(value = "SELECT * FROM Blog WHERE title = :title AND username = :username AND author = :author",nativeQuery = true)
    List<Blog> findBlog(@Param("title") String title,@Param("username") String username,@Param("author") String authorName);

    @Query(value = "UPDATE Blog SET likes = likes-1 WHERE username = :username AND title = :title AND author = :author",nativeQuery = true)
    void removeLike(@Param("title") String title,@Param("username") String username,@Param("author") String authorName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Blog WHERE username = :username AND title = :title AND author = :author",nativeQuery = true)
    void deleteBlog(@Param("title") String title,@Param("username") String username,@Param("author") String authorName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM blog_comments WHERE blog_id = (SELECT id FROM Blog WHERE title = :title AND username = :username AND author = :author) AND comment = :comment", nativeQuery = true)
    void deleteComment(@Param("title") String title, @Param("username") String username, @Param("author") String author, @Param("comment") String comment);

    @Query(value = "SELECT * FROM Blog",nativeQuery = true)
    List<Blog> returnAllBlogs();
}
