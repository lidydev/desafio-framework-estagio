package br.com.framework.desafio.service;

import br.com.framework.desafio.client.JSONPlaceHolderClient;
import br.com.framework.desafio.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PostService {

    @Autowired
    public JSONPlaceHolderClient jsonPlaceHolderClient;

    public List<Post> getAllPosts(){
        log.info("METHOD: getAllPosts");
        return jsonPlaceHolderClient.getAllPosts();
    }

}
