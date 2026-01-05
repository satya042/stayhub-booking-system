package com.backend.stayHubApp.dto;

import com.backend.stayHubApp.entity.Hotel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RoomDto {
    private Long id;
    private Hotel hotel;
    private String type;
    private BigDecimal basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;
}
