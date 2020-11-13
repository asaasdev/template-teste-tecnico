package com.asaas.logger

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import static grails.async.Promises.task

class Logger {

    static final DATE_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS"

    public static void info(String message) {
        logAsync("INFO", message, null)
    }

    public static void warn(String message) {
        logAsync("WARN", message, null)
    }

    public static void warn(String message, Exception e) {
        logAsync("WARN", message, e)
    }

    public static void error(String message) {
        logAsync("ERROR", message, null)
    }

    public static void error(String message, Exception e) {
        logAsync("ERROR", message, e)
    }

    public static void logAsync(String type, String message, Exception e) {
        Long threadId = Thread.currentThread().getId()

        task {
            if (e) {
                message = message ? "${message}. " : ""
                message = "${message}Stacktrace follows:\n${buildExceptionStackTrace(e)}"
            }

            LocalDateTime now = LocalDateTime.now()
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN)

            println "${now.format(dateTimeFormatter)} [Thread-${threadId}] ${type} ${message}"
        }
    }

    private static String buildExceptionStackTrace(Exception exception) {
        StringWriter stringWriter = new StringWriter()
        PrintWriter printWriter = new PrintWriter(stringWriter)
        exception.printStackTrace(printWriter)
        return stringWriter.toString()
    }

}
