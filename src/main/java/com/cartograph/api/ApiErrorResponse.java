package com.cartograph.api;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Stable JSON error body returned by the HTTP API.
 *
 * @param code machine-readable error identifier
 * @param message safe, human-readable explanation that does not expose internal details
 * @param correlationId request correlation id (omitted when unavailable); matches the
 *                      {@code X-Request-Id} response header and the server log context
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiErrorResponse(String code, String message, String correlationId) {
    public ApiErrorResponse(String code, String message) {
        this(code, message, MdcHolder.current());
    }

    /** Reads the correlation id from the logging context without a direct filter dependency. */
    private static final class MdcHolder {
        private static String current() {
            return org.slf4j.MDC.get(CorrelationIdFilter.MDC_KEY);
        }
    }
}
