package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.dto.ProfileUpdateRequestDto;
import com.backend.stayHubApp.dto.UserDto;
import com.backend.stayHubApp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}
