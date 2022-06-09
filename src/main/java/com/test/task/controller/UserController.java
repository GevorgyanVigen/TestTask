package com.test.task.controller;

import com.test.task.model.requestdto.CreateUserAccountDTO;
import com.test.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("create-account")
    public ResponseEntity<Void> createAccount(@RequestBody CreateUserAccountDTO accountDTO) {
        userService.createAccount(accountDTO);
        return ResponseEntity.ok().build();
    }
}
