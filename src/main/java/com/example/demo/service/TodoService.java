package com.example.demo.service;

import com.example.demo.entity.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TodoService {
     List<ToDo> getAllTodo();
     void saveToDo(ToDo toDo);
     void updateTodo(Long id, ToDo toDo);
     ToDo getTodoById(Long id);
     void deleteTodo(Long id);
}
