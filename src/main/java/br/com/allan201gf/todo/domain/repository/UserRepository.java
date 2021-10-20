package br.com.allan201gf.todo.domain.repository;

import br.com.allan201gf.todo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
