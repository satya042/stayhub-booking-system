package com.backend.stayHubApp.strategy;

public abstract class PricingDecorator implements PricingStrategy{

    protected final PricingStrategy pricingStrategy;

    public PricingDecorator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
}
