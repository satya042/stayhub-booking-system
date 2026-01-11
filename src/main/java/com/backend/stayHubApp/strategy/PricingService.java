package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PricingService {
    public BigDecimal calculateDynamicPricing(Inventory inventory){

        PricingStrategy pricingStrategy = new HolidayPricingStrategy(
                new UrgencyPricingStrategy(
                        new OccupancyPricingStrategy(
                                new SurgePricingStrategy(
                                        new BasePricingStrategy()))));

        return pricingStrategy.calculatePrice(inventory);
    }

    //    Return the sum of price of this inventory list
    public BigDecimal calculateTotalPrice(List<Inventory> inventoryList) {
        return inventoryList.stream()
                .map(this::calculateDynamicPricing)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}