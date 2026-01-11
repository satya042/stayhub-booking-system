package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.dto.BookingDto;
import com.backend.stayHubApp.dto.BookingRequest;
import com.backend.stayHubApp.dto.GuestDto;
import com.stripe.model.Event;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;


public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);

    String initiatePayments(Long bookingId);

    void capturePayment(Event event);

    void cancelBooking(Long bookingId);

    String getBookingStatus(Long bookingId);
}
