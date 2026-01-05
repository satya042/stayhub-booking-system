package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;

import java.math.BigDecimal;

public class HolidayPricingStrategy extends PricingDecorator {

    public HolidayPricingStrategy(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        boolean isTodayHoliday = true; // call an api or check with local date
        if(isTodayHoliday){
            price = price.multiply(BigDecimal.valueOf(1.25));
        }
        return price;
    }
}
