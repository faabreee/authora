package com.authora.domain.model;

import com.authora.application.dto.RegisterUserCommand;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Person {
    private Long id;
    private String uuid;
    private DocumentType documentType;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Date birthDate;
    private Gender gender;
    private Integer status;

    public Person() {}

    public Person(RegisterUserCommand registerUserCommand) {
        this.uuid = UUID.randomUUID().toString();
        this.documentType = new DocumentType(registerUserCommand.documentTypeId());
        this.documentNumber = registerUserCommand.documentNumber();
        this.firstName = registerUserCommand.firstName();
        this.secondName = registerUserCommand.secondName();
        this.firstLastName = registerUserCommand.firstLastName();
        this.secondLastName = registerUserCommand.secondLastName();
        this.birthDate = registerUserCommand.birthDate();
        this.gender = new Gender(registerUserCommand.genderId());
        this.status = 1;
    }
}
