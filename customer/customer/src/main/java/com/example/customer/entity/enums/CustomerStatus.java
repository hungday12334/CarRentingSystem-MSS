package com.example.customer.entity.enums;

public enum CustomerStatus {
    ACTIVE("Active"),
    BANNED("Banned"),
    PENDING_VERIFYING("Pending verify");

    private final String displayName;

    CustomerStatus(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return displayName;
    }
}
