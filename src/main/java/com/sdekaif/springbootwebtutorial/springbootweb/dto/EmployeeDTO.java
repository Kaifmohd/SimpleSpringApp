package com.sdekaif.springbootwebtutorial.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sdekaif.springbootwebtutorial.springbootweb.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Required field in Employee: name")
    @Size(min=2,max=10,message = "Number of characters in name should be in the range [3 and 10]")
    private String name;

    @Email(message = "Please enter valid email")
    private String email;

    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value=18, message = "Age cannot be less than 18")
    private Integer age;

//    @Pattern(regexp = "^(ADMIN|USER)$")
    @EmployeeRoleValidation
    private String role;//ADMIN,USER

    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;

    @Digits(integer = 6,fraction = 2,message = "Salary no more than 6 figures")
    private Double salary;
//    public EmployeeDTO(){
//
//    }
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dateOfJoining = dateOfJoining;
//        this.isActive = isActive;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public LocalDate getDateOfJoining() {
//        return dateOfJoining;
//    }
//
//    public void setDateOfJoining(LocalDate dateOfJoining) {
//        this.dateOfJoining = dateOfJoining;
//    }
//
//    public Boolean getIsActive() {
//        return isActive;
//    }
//
//    public void setIsActive(Boolean active) {
//        isActive = active;
//    }
}
