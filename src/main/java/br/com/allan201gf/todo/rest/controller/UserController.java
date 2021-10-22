package br.com.allan201gf.todo.rest.controller;

import br.com.allan201gf.todo.domain.entity.User;
import br.com.allan201gf.todo.rest.dto.UserDTO;
import br.com.allan201gf.todo.rest.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @ApiOperation("Criar um usuário")
    @PostMapping
    public int save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @ApiOperation("Deletar um usuário")
    @DeleteMapping
    public void delete(@RequestParam int idUser) {
        userService.delete(idUser);
    }

    @ApiOperation("Listar todos os usuários")
    @GetMapping
    public List<User> allUsers() {
        return userService.allUsers();
    }

    @ApiOperation("Alterar um usuário")
    @PatchMapping
    public void updateUser(@RequestParam int idUser, @RequestBody UserDTO userDTO) {
        userService.updateUser(idUser, userDTO);
    }


}
