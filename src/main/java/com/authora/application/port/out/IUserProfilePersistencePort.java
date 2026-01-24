package com.authora.application.port.out;

import com.authora.domain.model.UserProfile;

public interface IUserProfilePersistencePort {
    UserProfile save(UserProfile userProfile);
}
