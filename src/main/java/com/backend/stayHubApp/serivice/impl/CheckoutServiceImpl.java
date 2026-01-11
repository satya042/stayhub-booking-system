package com.backend.stayHubApp.serivice.impl;

import com.backend.stayHubApp.entity.Booking;
import com.backend.stayHubApp.entity.User;
import com.backend.stayHubApp.repository.BookingRepository;
import com.backend.stayHubApp.serivice.CheckoutService;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final BookingRepository bookingRepository;

    @Override
    public String getCheckoutSession(Booking booking, String successUrl, String failureUrl) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        try{
        Customer customer = Customer.create(CustomerCreateParams.builder()
                .setName(user.getName())
                .setEmail(user.getEmail())
                .build());

        SessionCreateParams.LineItem lineItems =  SessionCreateParams.LineItem.builder()
                .setQuantity(1L)
                .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("inr")
                                .setUnitAmount(booking.getAmount().multiply(BigDecimal.valueOf(100)).longValue())
                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                .setName(booking.getHotel().getName() + " : " + booking.getRoom().getType())
                                                .setDescription("Booking Id: " + booking.getId())
                                                .build())
                                .build())
                .build();

        SessionCreateParams sessionParams = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
                .setCustomer(customer.getId())
                .setSuccessUrl(successUrl)
                .setCancelUrl(failureUrl)
                .addLineItem(lineItems)
                .build();

        Session session = Session.create(sessionParams);

        booking.setPaymentSessionId(session.getId());
        bookingRepository.save(booking);
        return session.getUrl();
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
