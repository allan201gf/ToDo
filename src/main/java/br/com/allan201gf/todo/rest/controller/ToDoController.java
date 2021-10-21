package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.domain.entity.ToDo;
import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.domain.enums.StatusToDo;
import br.com.allan201gf.todo.rest.dto.ToDoDTO;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.ToDoService;
import br.com.allan201gf.todo.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;

    @PostMapping
    public ToDo save(@RequestBody ToDoDTO toDoDTO) {
        return toDoService.save(toDoDTO);
    }

    @PostMapping("/setstatus")
    public void setStatus(@RequestParam int idToDo, @RequestBody ToDoDTO ToDoDTO) {
        toDoService.setStatus(idToDo, ToDoDTO);
    }

    @GetMapping
    public List<ToDo> allToDo() {
        return toDoService.allToDo();
    }



}
