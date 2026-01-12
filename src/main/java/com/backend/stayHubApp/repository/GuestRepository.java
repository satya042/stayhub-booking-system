package com.backend.stayHubApp.repository;

import com.backend.stayHubApp.entity.Guest;
import com.backend.stayHubApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByUser(User user);
}
