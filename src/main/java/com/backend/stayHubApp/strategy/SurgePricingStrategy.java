package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;

import java.math.BigDecimal;

public class SurgePricingStrategy extends PricingDecorator{

    public SurgePricingStrategy(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        BigDecimal price = pricingStrategy.calculatePrice(inventory);
        return price.multiply(inventory.getSurgeFactor());
    }
}
