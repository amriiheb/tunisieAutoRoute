package tn.Proxym.ProxymAcademy.validator.user.username;

import tn.Proxym.ProxymAcademy.util.UsernameRules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername,String> {
    @Override
    public void initialize(ValidUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if(username.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Username must not be empty").addConstraintViolation() ;
            return  false ;
        }
        else if(!UsernameRules.validUsername(username)){
          context.disableDefaultConstraintViolation();
          context.buildConstraintViolationWithTemplate("Username invalid").addConstraintViolation() ;
          return false ;
        }

        return true;
    }
}
