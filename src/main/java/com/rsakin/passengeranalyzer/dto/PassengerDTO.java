package com.rsakin.passengeranalyzer.dto;

public record PassengerDTO(String firstname, String lastname, String gender,
                           Integer age, String phone, String email) {
}