package com.backend.stayHubApp.serivice;

import com.backend.stayHubApp.entity.Booking;

public interface CheckoutService {
    String getCheckoutSession(Booking booking, String successUrl, String failureUrl);
}
