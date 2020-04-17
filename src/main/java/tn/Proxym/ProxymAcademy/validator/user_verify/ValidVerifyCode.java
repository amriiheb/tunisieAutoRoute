package tn.Proxym.ProxymAcademy.validator.user_verify;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VerifyCodeValidator.class)
public @interface ValidVerifyCode {
    String message() default "Invalid code.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}
