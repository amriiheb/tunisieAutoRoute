package tn.Proxym.ProxymAcademy.validator.user.create_username;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreateUsernameValidator.class)
public @interface ValidCreateUsername {
    String message() default "Invalid username" ;
    Class<?>[] groups() default {} ;
    Class <? extends Payload>[] payload() default{} ;
}
