package br.com.allan201gf.todo.rest.service;

import br.com.allan201gf.todo.domain.entity.ToDo;
import br.com.allan201gf.todo.rest.dto.ToDoDTO;

import java.util.List;

public interface ToDoService {

    ToDo save(ToDoDTO toDoDTO);

    void setStatus(int idTodo, ToDoDTO toDoDTO);

    List<ToDo> allToDo();

    List<ToDo> toDoOfDay(String day);

}
