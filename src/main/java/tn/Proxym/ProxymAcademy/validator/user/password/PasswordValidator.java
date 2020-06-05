package tn.Proxym.ProxymAcademy.validator.user.password;

import tn.Proxym.ProxymAcademy.util.PasswordRules;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

public class PasswordValidator implements ConstraintValidator<ValidPassword,String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        Map<String,String> maps=new HashMap() ;
        if(!PasswordRules.validatePassword(password,maps)){
            String errorMessage=maps.get("errorMessage") ;
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMessage)
                    .addConstraintViolation() ;
                    return false ;
        }
        return  true ;
    }

}
