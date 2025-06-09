package com.mercadinho.mercadinho_uniesp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneBRValidator implements
        ConstraintValidator<TelefoneBR, String> {
    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext
            context) {
        if (telefone == null || telefone.isBlank()) return false;
// Remove qualquer caractere não numérico
        String numeros = telefone.replaceAll("[^\\d]", "");
// Verifica se tem exatamente 11 dígitos (2 do DDD + 9 do número)
        if (!numeros.matches("\\d{11}")) return false;
// Verifica se o terceiro dígito é 9 (celular)
        if (numeros.charAt(2) != '9') return false;
// Passa na validação!
        return true;
    }
}