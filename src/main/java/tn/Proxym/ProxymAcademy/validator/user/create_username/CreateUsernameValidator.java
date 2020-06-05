package tn.Proxym.ProxymAcademy.validator.user.create_username;

import org.springframework.beans.factory.annotation.Autowired;
import tn.Proxym.ProxymAcademy.service.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CreateUsernameValidator implements ConstraintValidator<ValidCreateUsername,String> {

  @Autowired
  private UserService userService;
  @Override
    public void initialize(ValidCreateUsername constraintAnnotation) {

    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

      if(userService.findByUsername(username).isPresent()){
          context.disableDefaultConstraintViolation();
          context.buildConstraintViolationWithTemplate("Username already taken").addConstraintViolation() ;
          return  false ;


      }
      return true;
    }
}
