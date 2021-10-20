package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public int save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping
    public void delete(@RequestParam int idUser) {
        userService.delete(idUser);
    }

    @GetMapping
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @PatchMapping
    public void updateUser(@RequestParam int idUser, @RequestBody UserDTO userDTO) {
        userService.updateUser(idUser, userDTO);
    }


}
