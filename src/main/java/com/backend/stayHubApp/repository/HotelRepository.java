package com.backend.stayHubApp.repository;

import com.backend.stayHubApp.entity.Hotel;
import com.backend.stayHubApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByOwner(User user);
}
