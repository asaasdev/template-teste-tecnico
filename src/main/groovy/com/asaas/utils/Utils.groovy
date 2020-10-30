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
}
