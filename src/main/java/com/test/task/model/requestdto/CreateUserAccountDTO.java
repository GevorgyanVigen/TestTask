package com.test.task.model.requestdto;

import lombok.Data;

@Data
public class CreateUserAccountDTO {

    private String name;

    private String surname;

    private String email;

    private String password;
}
