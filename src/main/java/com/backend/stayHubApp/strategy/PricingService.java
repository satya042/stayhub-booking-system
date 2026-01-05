package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
}