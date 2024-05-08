package com.example.demo.controller;

import com.example.demo.entity.ToDo;
import com.example.demo.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {
    @Autowired
    private TodoServiceImpl todoService;
    @GetMapping
    public List<ToDo>findAll(){
        return  todoService.getAllTodo();
    }
    @PostMapping
    public void save(@RequestBody ToDo toDo){
        todoService.saveToDo(toDo);
    }
    @GetMapping("{/id}")
    public ToDo findOne(@PathVariable Long id){
        return  todoService.getTodoById(id);
    }
    @PutMapping("{/id}")
    public void Update(@PathVariable Long id, @RequestBody ToDo todo){
        this.todoService.updateTodo(id,todo);
    }
    @DeleteMapping("{/id}")
    public void Delete(@PathVariable Long id){
        this.todoService.deleteTodo(id);
    }
}
