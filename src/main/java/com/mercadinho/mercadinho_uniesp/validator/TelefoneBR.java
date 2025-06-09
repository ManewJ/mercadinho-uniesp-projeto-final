package com.mercadinho.mercadinho_uniesp.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = TelefoneBRValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TelefoneBR {

    String message() default "Número de telefone inválido. Deve conter DDD + número (apenas números).";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
