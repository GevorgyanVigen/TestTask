package com.test.task.service;

import com.test.task.model.User;
import com.test.task.model.requestdto.CreateUserAccountDTO;
import com.test.task.util.exceptions.NotFoundException;

public interface UserService {

    User getByUsername(String email) throws NotFoundException;

    void createAccount(CreateUserAccountDTO dto);
}
