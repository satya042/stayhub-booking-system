package com.backend.stayHubApp.util;

import com.backend.stayHubApp.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class AppUtils {
    public static User getCurrentUser(){
        return  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
