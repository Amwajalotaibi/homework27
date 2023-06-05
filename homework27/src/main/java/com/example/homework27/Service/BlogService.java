package com.example.homework27.Service;

import com.example.homework27.Model.Blog;
import com.example.homework27.Repository.BlogRepository;
import com.example.homework27.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public List<Blog> getBlog(Integer userId) {

        return blogRepository.findBlogByUserId(userId);
    }

    public void addBlog(Integer userId, Blog blog) {

        userRepository.findUserById(userId);
        blog.setId(userId);
        blogRepository.save(blog);
    }

    public void deleteBlog(Integer userId, Integer blogId) {
        Blog blog = blogRepository.findBlogById(blogId);
        if (blog.getUserId() != userId) {
            throw new UsernameNotFoundException("Error,authentication");
        }

        blogRepository.save(blog);
    }

    public void updateBlog(Integer userId, Blog blog, Integer blogId) {
        Blog oldBlog = blogRepository.findBlogById(blogId);
        if (oldBlog == null) {
            throw new UsernameNotFoundException("Blog not found");
        }
        if (oldBlog.getUserId() != userId) {
            throw new UsernameNotFoundException("Error, authentication");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        blogRepository.save(oldBlog);
    }

    public Blog getBlogById(Integer id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog == null) {
            throw new ArithmeticException("ID not found");

        }
        return blog;
    }


    public Blog getBlogByTitle(String title) {
        Blog blog = blogRepository.findBlogByTitle(title);
        if (blog == null) {
            throw new ArithmeticException("Title not found");

        }
        return blog;
    }

}
