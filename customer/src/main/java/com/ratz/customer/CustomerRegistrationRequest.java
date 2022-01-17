package com.ratz.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
