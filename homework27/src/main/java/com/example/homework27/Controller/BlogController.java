package com.example.homework27.Controller;

import com.example.homework27.Model.Blog;
import com.example.homework27.Model.User;
import com.example.homework27.Service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlog(@AuthenticationPrincipal User user){
        List<Blog> blogList=blogService.getBlog(user.getId());
        return ResponseEntity.status(200).body(blogList);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal User user, @RequestBody Blog blog){
        blogService.addBlog(user.getId(), blog);
        return ResponseEntity.status(200).body("Blog Added");
    }

    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user,@PathVariable Integer blogId){
       blogService.deleteBlog(user.getId(), blogId);
       return ResponseEntity.status(200).body(" Blog delete");
    }

    @PutMapping ("/update/{blogId}")
    public ResponseEntity updateTodo(@AuthenticationPrincipal User user,@RequestBody Blog blog,@PathVariable Integer blogId){
       blogService.updateBlog(user.getId(), blog,blogId);
       return ResponseEntity.status(200).body("Blog Update ");
    }


    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        return ResponseEntity.status(200).body("get Bolg By Id"+blogService.getBlogById(id));
    }


    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
            return ResponseEntity.status(200).body("get Blog by Title"+blogService.getBlogByTitle(title));
        }

}
