package br.com.allan201gf.todo.domain.entity;

import br.com.allan201gf.todo.domain.enums.StatusToDo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ToDo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idToDo;

    private String name;

    private String description;

    private LocalDate dateEndTodo;

    private StatusToDo status;

    @ManyToOne
    @JoinColumn(name = "user_id_user")
    private User user;

}
