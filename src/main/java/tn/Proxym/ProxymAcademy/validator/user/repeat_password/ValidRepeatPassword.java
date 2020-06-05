package tn.Proxym.ProxymAcademy.validator.user.repeat_password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RepeatPasswordValidator.class)
@Documented
public @interface ValidRepeatPassword {

    String message() default "Passwords don't match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
