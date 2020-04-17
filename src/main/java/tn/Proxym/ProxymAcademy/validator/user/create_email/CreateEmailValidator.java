package tn.Proxym.ProxymAcademy.validator.user.create_email;

import org.springframework.beans.factory.annotation.Autowired;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateEmailValidator implements ConstraintValidator<ValidCreateEmail,String> {

    @Autowired
    private UserService userService;


    @Override
    public void initialize(ValidCreateEmail constraintAnnotation) {
ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        if(userService.findByEmail(email).isPresent()){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Email already taken").addConstraintViolation() ;
            return false ;
        }
        return true;
    }
}
