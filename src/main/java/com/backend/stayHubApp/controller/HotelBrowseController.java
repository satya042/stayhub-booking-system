package com.backend.stayHubApp.controller;

import com.backend.stayHubApp.dto.HotelInfoDto;
import com.backend.stayHubApp.dto.HotelPriceDto;
import com.backend.stayHubApp.dto.HotelSearchRequest;
import com.backend.stayHubApp.serivice.HotelService;
import com.backend.stayHubApp.serivice.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelPriceDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest){
        Page<HotelPriceDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return  ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }

}
