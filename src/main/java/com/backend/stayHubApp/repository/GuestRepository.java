package com.backend.stayHubApp.repository;

import com.backend.stayHubApp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
