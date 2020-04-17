package tn.Proxym.ProxymAcademy.validator.user.update_email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpdateEmailValidator implements ConstraintValidator<ValidUpdateEmail,Object>
{
    @Override
    public void initialize(ValidUpdateEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {




        return false;
    }
}
