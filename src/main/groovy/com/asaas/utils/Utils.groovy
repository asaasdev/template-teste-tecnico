package com.asaas.utils

import grails.compiler.GrailsCompileStatic
import groovy.transform.TypeCheckingMode

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.regex.Matcher
import java.util.regex.Pattern

@GrailsCompileStatic
class Utils {

    private static final String YYYYMMDD_FORMAT = "yyyy-MM-dd"

    @GrailsCompileStatic(TypeCheckingMode.SKIP)
    public static Object addError(Object entity, String message) {
        entity.errors.reject(message, null, message)
        return entity
    }

    @GrailsCompileStatic(TypeCheckingMode.SKIP)
    public static Object copyErrorsFromObject(Object fromObject, Object toObject) {
        if (!fromObject.hasErrors()) return toObject

        for (String domainError : fromObject.errors) {
            Utils.addError(toObject, domainError)
        }

        return toObject
    }

    public static Boolean isValidEmail(String email) {
        final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})"
        final Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE)

        Matcher matcher = pattern.matcher(email)
        return matcher.matches()
    }

    @GrailsCompileStatic(TypeCheckingMode.SKIP)
    public static BigDecimal toBigDecimal(value) {
        try {
            if (value instanceof BigDecimal) return value
            if (value instanceof Double) return BigDecimal.valueOf(value)
            if (value instanceof String) return BigDecimal.valueOf(value.toDouble())
            return null
        } catch (Exception e) {
            return null
        }
    }

    public static Date toDate(Object fromDate) {
        if (fromDate instanceof Date) return fromDate
        return Utils.toDate(fromDate, Utils.YYYYMMDD_FORMAT)
    }

    public static Date toDate(Object fromDate, String pattern) {
        try {
            LocalDate localDate = LocalDate.parse(fromDate.toString(), DateTimeFormatter.ofPattern(pattern))
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant())
        } catch (Exception e) {
            e.printStackTrace()
            return null
        }
    }

    public static String fromDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Utils.YYYYMMDD_FORMAT)
        if (!date) return null
        return simpleDateFormat.format(date)
    }    

    public static boolean isCNPJ(String CNPJ) {
    // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
        (CNPJ.length() != 14))
        return(false);

        char dig13, dig14;
        int sm, i, r, num, peso;

    // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
    // Calculo do 1o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i=11; i>=0; i--) {
    // converte o i-ésimo caractere do CNPJ em um número:
    // por exemplo, transforma o caractere '0' no inteiro 0
    // (48 eh a posição de '0' na tabela ASCII)
            num = (int)(CNPJ.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
            peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig13 = '0';
        else dig13 = (char)((11-r) + 48);

    // Calculo do 2o. Digito Verificador
        sm = 0;
        peso = 2;
        for (i=12; i>=0; i--) {
            num = (int)(CNPJ.charAt(i)- 48);
            sm = sm + (num * peso);
            peso = peso + 1;
            if (peso == 10)
            peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
            dig14 = '0';
        else dig14 = (char)((11-r) + 48);

    // Verifica se os dígitos calculados conferem com os dígitos informados.
        if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
            return(true);
        else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }


   
}
