package com.example.startproj.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = {})
@NotNull
@Size(min = 2, max = 15, message = "Ограничение длины имени 15 символов.")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Имя может содержать только буквы и пробелы.")
public @interface ValidName {
    String message() default "Неверный формат имени";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
