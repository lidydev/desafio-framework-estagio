package br.com.framework.desafio.controller;

import br.com.framework.desafio.domain.Post;
import br.com.framework.desafio.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @Cacheable(value = "postCache")
    @GetMapping("")
    public List<Post> getAllTodos(){
        return postService.getAllPosts();
    }

}
