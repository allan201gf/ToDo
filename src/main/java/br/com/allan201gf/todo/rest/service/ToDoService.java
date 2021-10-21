package br.com.allan201gf.todo.rest.service;

import br.com.allan201gf.todo.domain.entity.ToDo;
import br.com.allan201gf.todo.rest.dto.ToDoDTO;

public interface ToDoService {

    ToDo save(ToDoDTO toDoDTO);

}
