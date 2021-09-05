package br.com.framework.desafio.controller;

import br.com.framework.desafio.domain.Post;
import br.com.framework.desafio.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    PostService postService;

    @Cacheable(value = "postCache")
    @GetMapping("/list")
    public List<Post> getAllTodos(){
        return postService.getAllPosts();
    }

}
