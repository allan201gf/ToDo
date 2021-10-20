package br.com.allan201gf.todo.rest.service;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.rest.dto.UserDTO;

public interface UserService {

    int save (UserDTO userDTO);

}
