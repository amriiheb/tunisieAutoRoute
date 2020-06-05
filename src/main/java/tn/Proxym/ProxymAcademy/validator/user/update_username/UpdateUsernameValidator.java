package tn.Proxym.ProxymAcademy.validator.user.update_username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateUsernameValidator implements ConstraintValidator<ValidUpdateUsername,String> {

    @Override
    public void initialize(ValidUpdateUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
