package br.com.allan201gf.todo.rest.service.impl;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.domain.exception.RuleOfException;
import br.com.allan201gf.todo.domain.repository.UserRepository;
import br.com.allan201gf.todo.domain.validation.ValidationCPF;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public int save(UserDTO userDTO) {

        if (!ValidationCPF.isCPF(userDTO.getCPF())) {
            throw new RuleOfException("CPF inválido");
        }

        if (userDTO.getName().isEmpty()) {
            throw new RuleOfException("O Compo nome está vazio");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setCPF(userDTO.getCPF());
        userRepository.save(user);
        return user.getIdUser();
    }
}
