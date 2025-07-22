package com.ttn.restservice1.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Employee(@Min(value = 10, message = "Age cannot be less than 10") int age,
                       int id,
                       @NotBlank @Size(min = 3, message = "Name cannot be less than 3 character") String name
) {

}