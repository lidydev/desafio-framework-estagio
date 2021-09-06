package br.com.framework.desafio.controller;

import br.com.framework.desafio.domain.Todo;
import br.com.framework.desafio.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

}
