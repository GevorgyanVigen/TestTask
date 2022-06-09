package com.test.task.service.impl;

import com.test.task.model.User;
import com.test.task.model.requestdto.CreateUserAccountDTO;
import com.test.task.repository.UserRepository;
import com.test.task.service.UserService;
import com.test.task.util.exceptions.ErrorMessage;
import com.test.task.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getByUsername(String email) throws NotFoundException {

        User user = userRepository.getByUsername(email);

        if (user == null){
            throw new NotFoundException(ErrorMessage.NOT_FOUND_USER);
        }
        return user;
    }

    @Override
    public void createAccount(CreateUserAccountDTO dto) {
        User user = new User();
        user.setFirstName(dto.getName());
        user.setLastName(dto.getSurname());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        userRepository.save(user);
    }
}
