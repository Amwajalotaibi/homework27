package com.example.homework27.Repository;

import com.example.homework27.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findBlogByUserId(Integer Id);
    Blog findBlogById(Integer id);

    Blog findBlogByTitle(String title);
}
