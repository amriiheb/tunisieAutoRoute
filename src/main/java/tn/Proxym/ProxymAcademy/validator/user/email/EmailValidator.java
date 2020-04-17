package tn.Proxym.ProxymAcademy.validator.user.email;

import tn.Proxym.ProxymAcademy.util.EmailRules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail,String> {
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
         ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(email.isEmpty()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email not be empty").addConstraintViolation() ;

            return false ;
        }

        if(!EmailRules.validateEmail(email)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email invalid")
                    .addConstraintViolation() ;
            return false ;
        }
        return true;
    }
}
