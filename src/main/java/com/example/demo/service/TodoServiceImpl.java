package com.example.demo.service;

import com.example.demo.entity.ToDo;
import com.example.demo.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements  TodoService{
    @Autowired
    private TodoRepo todoRepo;

    @Override
    public List<ToDo> getAllTodo() {
        return todoRepo.findAll();
    }

    @Override
    public void saveToDo(ToDo todo) {
        this.todoRepo.save(todo);
    }

    @Override
    public ToDo getTodoById(Long id) {
        Optional<ToDo> optional= todoRepo.findById(id);
        ToDo toDo;
        if (optional.isPresent()){
            toDo= optional.get();
        }
        else{
            throw new RuntimeException("Todo for the id " + id + "is not found!!");
        }
        return toDo;

    }

    @Override
    public void updateTodo(Long id, ToDo toDo) {
        ToDo todoFromDb = todoRepo.findById(id).get();
        todoFromDb.setTaskName(toDo.getTaskName());
        todoFromDb.setDesc(toDo.getDesc());
        todoRepo.save(todoFromDb);
    }



    @Override
    public void deleteTodo(Long id) {
    this.todoRepo.deleteById(id);
    }
}
