package br.com.allan201gf.todo.rest.service.impl;

import br.com.allan201gf.todo.domain.entity.ToDo;
import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.domain.exception.RuleOfException;
import br.com.allan201gf.todo.domain.repository.ToDoRepository;
import br.com.allan201gf.todo.domain.repository.UserRepository;
import br.com.allan201gf.todo.rest.dto.ToDoDTO;
import br.com.allan201gf.todo.rest.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    UserRepository userRepository;
    ToDoRepository toDoRepository;

    @Override
    public ToDo save(ToDoDTO toDoDTO) {

        if (toDoDTO.getName().isEmpty()) {
            throw new RuleOfException("O nome precisa ser preenchido");
        }

        User user = userRepository.findById(toDoDTO.getUser()).orElseThrow(
                () -> new RuleOfException("Usuário não encontrado")
        );

        LocalDate dataEndTodoFormated = stringForDate(toDoDTO.getDataEndTodo());

        ToDo toDo = new ToDo();
        toDo.setName(toDoDTO.getName());
        toDo.setDescription(toDoDTO.getDescription());
        toDo.setDateEndTodo(dataEndTodoFormated);

        return toDoRepository.save(toDo);


    }

    public LocalDate stringForDate (String dateString) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateString, format);
        } catch (Exception e) {
            throw new RuleOfException("Data invalida ou nula, formato correto: dd/mm/aaaa ");
        }

    }

}
