package com.rsakin.passengeranalyzer.dto;

import lombok.Data;

@Data
public class PassengerDTO {

    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private String phone;
    private String email;
}