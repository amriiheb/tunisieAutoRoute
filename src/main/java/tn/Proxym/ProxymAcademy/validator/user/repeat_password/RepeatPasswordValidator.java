package tn.Proxym.ProxymAcademy.validator.user.repeat_password;

import tn.Proxym.ProxymAcademy.dto.UserCreateDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RepeatPasswordValidator  implements ConstraintValidator<ValidRepeatPassword,Object> {

    @Override
    public void initialize(ValidRepeatPassword constraintAnnotation) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value instanceof UserCreateDto) {
            UserCreateDto dto = (UserCreateDto) value;

            if (dto.getPassword().isEmpty()) {
                context.buildConstraintViolationWithTemplate( "Password not be empty" )
                        .addPropertyNode( "repeatPassword" )
                        .addConstraintViolation();
                return false;

            }

            if (!dto.getPassword().equals(dto.getRepeatPassword())) {
                context.buildConstraintViolationWithTemplate( "Passwords don't match" )
                        .addPropertyNode( "repeatPassword" )
                        .addConstraintViolation();
                return false;

            }
        }



        return true;
    }

}

