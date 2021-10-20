package br.com.allan201gf.todo.domain.repository;

import br.com.allan201gf.todo.domain.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {



}
