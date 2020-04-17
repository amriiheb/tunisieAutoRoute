package tn.Proxym.ProxymAcademy.validator.user.update_email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpdateEmailValidator.class)
@Documented
public @interface ValidUpdateEmail {

    String message() default "Invalid email.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};





}
