package br.com.allan201gf.todo.rest.service;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.rest.dto.UserDTO;

import java.util.List;

public interface UserService {

    int save (UserDTO userDTO);

    void delete(int idUser);

    List<User> allUsers();

    void updateUser(int idUser, UserDTO userDTO);

}
