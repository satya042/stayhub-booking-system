package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;

import java.math.BigDecimal;

public class OccupancyPricingStrategy extends PricingDecorator{

    public OccupancyPricingStrategy(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        double occupancyRate = (double) inventory.getBookedCount() / inventory.getTotalCount();
        if(occupancyRate > 0.8){
            price = price.multiply(BigDecimal.valueOf(1.2));
        }
        return price;
    }
}
