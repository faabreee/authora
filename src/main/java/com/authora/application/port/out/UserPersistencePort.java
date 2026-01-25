package com.authora.application.port.out;

import com.authora.domain.model.User;

public interface UserPersistencePort {
    User findByUsername(String username);
    User save(User user);
}
