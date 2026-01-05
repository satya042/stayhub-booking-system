package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.dto.HotelPriceDto;
import com.backend.stayHubApp.dto.HotelSearchRequest;
import com.backend.stayHubApp.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
