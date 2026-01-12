package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.dto.HotelPriceDto;
import com.backend.stayHubApp.dto.HotelSearchRequest;
import com.backend.stayHubApp.dto.InventoryDto;
import com.backend.stayHubApp.dto.UpdateInventoryRequestDto;
import com.backend.stayHubApp.entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);

    List<InventoryDto> getAllInventoryByRoom(Long roomId);

    void updateInventory(Long roomId, UpdateInventoryRequestDto updateInventoryRequestDto);
}
