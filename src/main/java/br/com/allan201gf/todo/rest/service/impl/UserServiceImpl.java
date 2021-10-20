package br.com.allan201gf.todo.rest.service.impl;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.domain.exception.RuleOfException;
import br.com.allan201gf.todo.domain.repository.UserRepository;
import br.com.allan201gf.todo.domain.validation.ValidationCPF;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

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

        List<User> allUser = allUsers();

        for (User user: allUser) {
            if (user.getCPF().equals(userDTO.getCPF())){
                throw new RuleOfException("CPF ja cadastrado");
            }
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setCPF(userDTO.getCPF());
        userRepository.save(user);
        return user.getIdUser();
    }

    @Override
    public void delete(int idUser) {
        try{
            userRepository.deleteById(idUser);
        } catch (EmptyResultDataAccessException e) {
            throw new RuleOfException("Id inválido");
        }
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(int idUser, UserDTO userDTO) {

        if (userDTO.getName().isEmpty()) {
            throw new RuleOfException("O Compo nome está vazio");
        }

        userRepository.findById(idUser).map(user -> {
            user.setName(userDTO.getName());
            return userRepository.save(user);
        }).orElseThrow( () -> new RuleOfException("Usuario não encontrado"));
    }
}
