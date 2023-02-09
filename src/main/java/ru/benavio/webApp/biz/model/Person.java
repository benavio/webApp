package ru.benavio.webApp.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message= "Please enter: First name")
    private String firstname;

    @NotEmpty(message= "Please enter: Last name")
    private String lastname;

    @Past(message= "Date of birth must be in the past")
    @NotNull(message = "Date of birth must be valid")
    private LocalDate dob;

    @NotEmpty(message = "Email must be empty")
    @Email(message = "Email must be valid")
    private String email;
    @DecimalMin(value = "1000.00",message = "Salary must be least then 1000")
    @NotNull(message = "Salary can not be empty")
    private BigDecimal salary;


}
