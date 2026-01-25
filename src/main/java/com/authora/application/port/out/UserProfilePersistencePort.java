package com.authora.application.port.out;

import com.authora.domain.model.UserProfile;

public interface UserProfilePersistencePort {
    UserProfile save(UserProfile userProfile);
}
