package com.backend.stayHubApp.strategy;

import com.backend.stayHubApp.entity.Inventory;

import java.math.BigDecimal;

public interface PricingStrategy {
    BigDecimal calculatePrice(Inventory inventory);
}
