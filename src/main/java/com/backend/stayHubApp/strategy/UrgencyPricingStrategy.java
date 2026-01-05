package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UrgencyPricingStrategy extends PricingDecorator {

    public UrgencyPricingStrategy(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        LocalDate today = LocalDate.now();

        if(inventory.getDate().isBefore(today) && inventory.getDate().isBefore(today.plusDays(7))){
            price = price.multiply(BigDecimal.valueOf(1.5));
        }
        return price;
    }
}
