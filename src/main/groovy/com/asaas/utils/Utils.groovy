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

    private static final String YYYYMMDD_FORMAT = 'yyyy-MM-dd'

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


    public static Boolean isValidCpfCnpj(String cpfCnpj) {
        String result = ''

        if (cpfCnpj.equals('00000000000') || cpfCnpj.equals('11111111111') || cpfCnpj.equals('22222222222') || cpfCnpj.equals('33333333333') || cpfCnpj.equals('44444444444') || cpfCnpj.equals('55555555555') || cpfCnpj.equals('66666666666') || cpfCnpj.equals('77777777777') || cpfCnpj.equals('88888888888') || cpfCnpj.equals('99999999999') || (cpfCnpj.length() < 11)) {
            result = ''
        }else if (cpfCnpj.length() == 11) {
            char dig10, dig11
            int sm, i, r, num, peso

            try {
                sm = 0
                peso = 10
                for (i = 0; i < 9; i++) {
                    num = (int) (cpfCnpj.charAt(i) - 48)
                    sm = sm + (num * peso)
                    peso = peso - 1
                }

                r = 11 - (sm % 11)
                if ((r == 10) || (r == 11)) {
                    dig10 = '0'
                }
                else {
                    dig10 = (r + 48)
                }

                sm = 0
                peso = 11
                for (i = 0; i < 10; i++) {
                    num = (int) (cpfCnpj.charAt(i) - 48)
                    sm = sm + (num * peso)
                    peso = peso - 1
                }

                r = 11 - (sm % 11)
                if ((r == 10) || (r == 11)) {
                    dig11 = '0'
                }
                else {
                    dig11 = (r + 48)
                }

                if ((dig10 == cpfCnpj.charAt(9)) && (dig11 == cpfCnpj.charAt(10))) {
                    result = 'cpfCnpj valid'
                }
                else {
                    result = ''
                }
            } catch (InputMismatchException erro) {
                result = ''
            }
        }else if (cpfCnpj.equals('00000000000000') || cpfCnpj.equals('11111111111111') || cpfCnpj.equals('22222222222222') || cpfCnpj.equals('33333333333333') || cpfCnpj.equals('44444444444444') || cpfCnpj.equals('55555555555555') || cpfCnpj.equals('66666666666666') || cpfCnpj.equals('77777777777777') || cpfCnpj.equals('88888888888888') || cpfCnpj.equals('99999999999999') || (cpfCnpj.length() < 14)) {
            result = ''
        }else {
            char dig13, dig14
            int sm, i, r, num, peso

            try {
                sm = 0
                peso = 2
                for (i = 11; i >= 0; i--) {
                    num = (int) (cpfCnpj.charAt(i) - 48)
                    sm = sm + (num * peso)
                    peso = peso + 1
                    if (peso == 10) {
                        peso = 2
                    }
                }

                r = sm % 11
                if ((r == 0) || (r == 1)) {
                    dig13 = '0'
                }
                else {
                    dig13 = ((11 - r) + 48)
                }

                sm = 0
                peso = 2
                for (i = 12; i >= 0; i--) {
                    num = (int) (cpfCnpj.charAt(i) - 48)
                    sm = sm + (num * peso)
                    peso = peso + 1
                    if (peso == 10) {
                        peso = 2
                    }
                }

                r = sm % 11
                if ((r == 0) || (r == 1)) {
                    dig14 = '0'
                }
                else {
                    dig14 = ((11 - r) + 48)
                }

                if ((dig13 == cpfCnpj.charAt(12)) && (dig14 == cpfCnpj.charAt(13))) {
                    result = 'cpfCnpj valid'
                }
                else {
                    result = ''
                }
            } catch (InputMismatchException erro) {
                result = ''
            }
        }

        final String cpfCnpjPattern = 'cpfCnpj valid'
        final Pattern pattern = Pattern.compile(cpfCnpjPattern, Pattern.CASE_INSENSITIVE)
        Matcher matcher = pattern.matcher(result)
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

}
