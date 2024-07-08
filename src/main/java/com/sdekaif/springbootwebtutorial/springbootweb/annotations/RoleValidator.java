package com.sdekaif.springbootwebtutorial.springbootweb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RoleValidator implements ConstraintValidator<EmployeeRoleValidation,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null) return false;

        List<String> roles = List.of("USER","ADMIN");
        return roles.contains(value);
    }
}
