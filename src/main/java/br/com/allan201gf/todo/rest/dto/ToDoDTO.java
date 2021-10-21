package br.com.allan201gf.todo.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDTO {

    private int user;
    private String name;
    private String description;
    private String dataEndTodo;
    private String status;

}
