package com.cwp.alice.model;

public enum CaseStatus {
    PENDING_REVIEW("Pending Review"),
    APPROVED("Approved"),
    DENIED("Denied"),
    UNKNOWN("");

    private String value;

    CaseStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
