package br.com.allan201gf.todo.domain.repository;

import br.com.allan201gf.todo.domain.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    @Query("select p from ToDo p where p.dateEndTodo like :day")
    List<ToDo> dayToDo(LocalDate day);

}
