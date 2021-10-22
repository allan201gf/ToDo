package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.domain.entity.ToDo;
import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.domain.enums.StatusToDo;
import br.com.allan201gf.todo.rest.dto.ToDoDTO;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.ToDoService;
import br.com.allan201gf.todo.rest.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;

    @ApiOperation("Criar uma tarefa")
    @PostMapping
    public ToDo save(@RequestBody ToDoDTO toDoDTO) {
        return toDoService.save(toDoDTO);
    }

    @ApiOperation("Alterar status de uma tarefa")
    @PostMapping("/setstatus")
    public void setStatus(@RequestParam int idToDo, @RequestBody ToDoDTO ToDoDTO) {
        toDoService.setStatus(idToDo, ToDoDTO);
    }

    @ApiOperation("Listar todas as tarefas")
    @GetMapping
    public List<ToDo> allToDo() {
        return toDoService.allToDo();
    }

    @ApiOperation("Listar as tarefas de um determinado dia")
    @GetMapping("/todoforday")
    public List<ToDo> toDoOfDay (@RequestParam String day) {
        return toDoService.toDoOfDay(day);
    }



}
