package tn.Proxym.ProxymAcademy.validator.user_verify;

import org.springframework.beans.factory.annotation.Autowired;
import tn.Proxym.ProxymAcademy.dao.verify_user.VerifyUserDao;
import tn.Proxym.ProxymAcademy.model.VerifyAccount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VerifyCodeValidator implements ConstraintValidator<ValidVerifyCode,String> {
    @Autowired
    private VerifyUserDao verifyUserDao;

    @Override
    public void initialize(ValidVerifyCode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String token, ConstraintValidatorContext context) {
        if(token.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Code not be empty")
                    .addConstraintViolation();
            return false;
        } else if(!verifyUserDao.findByToken(token).isPresent()) {

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Code verification not found")
                    .addConstraintViolation();
            return false;


        } else {
            VerifyAccount verifyAccount = verifyUserDao.findByToken(token).get();
            if(verifyAccount.isExpired()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Verification code has expired")
                        .addConstraintViolation();
                return false;
            }
        }


        return true;

    }
}
