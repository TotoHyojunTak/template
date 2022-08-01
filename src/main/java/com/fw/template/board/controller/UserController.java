package com.fw.template.board.controller;

import com.fw.template.board.model.User;
import com.fw.template.board.repository.UserRepository;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@Api(value="UserController Swagger", tags = "UserController")
@Slf4j
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user/{id}")
    public User addUser(@RequestBody User newUser, @PathVariable String id){
        log.info("id : {}", id);

        return userRepository.findById(id)
                .map(user -> {
                    log.info("이미 있는 회원");
                    return user;
                })
                .orElseGet(() -> {
                    log.info("신규 가입");

                    newUser.setId(id);
                    return userRepository.save(newUser);
                });

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
