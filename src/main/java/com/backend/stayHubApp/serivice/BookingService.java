package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.dto.BookingDto;
import com.backend.stayHubApp.dto.BookingRequest;
import com.backend.stayHubApp.dto.GuestDto;

import java.util.List;


public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
