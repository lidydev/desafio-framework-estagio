package br.com.framework.desafio.service;

import br.com.framework.desafio.client.JSONPlaceHolderClient;
import br.com.framework.desafio.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    public JSONPlaceHolderClient jsonPlaceHolderClient;

    public List<Todo> getAllTodos(){
        log.info("METHOD: getAllTodos");
        return jsonPlaceHolderClient.getAllTodos();
    }

}
