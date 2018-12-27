package com.jwt.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jwt.model.Employee;

public class EmployeeValidator implements Validator 
{
 
    public boolean supports(Class clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) 
    {
       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.firstName", "Username is required.");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.lastName", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password");

    }
 
}
