package com.backend.stayHubApp.dto;

import com.backend.stayHubApp.entity.User;
import com.backend.stayHubApp.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
