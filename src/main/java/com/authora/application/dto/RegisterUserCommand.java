package com.authora.application.dto;

import java.util.Date;

public record RegisterUserCommand(
        Long documentTypeId,
        String documentNumber,
        String firstName,
        String secondName,
        String firstLastName,
        String secondLastName,
        Date birthDate,
        Long genderId,
        String phone,
        String username,
        String password,
        String email,
        String emailVerified
) {}
