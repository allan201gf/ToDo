package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public int save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }


}
