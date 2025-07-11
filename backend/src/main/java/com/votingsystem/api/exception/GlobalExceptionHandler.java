package com.votingsystem.api.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // ==== AUTHENTICATION & AUTHORIZATION ======================
    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public ResponseEntity<ApiError> handleInvalidJwtAuthenticationException(
            InvalidJwtAuthenticationException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.UNAUTHORIZED, e, request);
    }

    @ExceptionHandler(UnauthorizedActionException.class)
    public ResponseEntity<ApiError> handleUnauthorizedActionException(
            UnauthorizedActionException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.FORBIDDEN, e, request);
    }

    @ExceptionHandler(VoteNotAllowedException.class)
    public ResponseEntity<ApiError> handleVoteNotAllowedException(
            VoteNotAllowedException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.FORBIDDEN, e, request);
    }

    // ==== BUSINESS RULES / DOMAIN =====================
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(
            UserNotFoundException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.NOT_FOUND, e, request);
    }

    @ExceptionHandler(PollNotFoundException.class)
    public ResponseEntity<ApiError> handlePollNotFound(
            PollNotFoundException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.NOT_FOUND, e, request);
    }

    @ExceptionHandler(OptionNotFoundException.class)
    public ResponseEntity<ApiError> handleOptionNotFoundException(
            OptionNotFoundException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.NOT_FOUND, e, request);
    }

    @ExceptionHandler(AlreadyVotedException.class)
    public ResponseEntity<ApiError> handleAlreadyVotedException(
            AlreadyVotedException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.CONFLICT, e, request);
    }

    @ExceptionHandler(InvalidPollOptionsException.class)
    public ResponseEntity<ApiError> handleInvalidPollOptionsException(
            InvalidPollOptionsException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.BAD_REQUEST, e, request);
    }

    // ==== VALIDATION =====================================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e,
            HttpServletRequest request)
    {
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(field -> field.getField() + ": " + field.getDefaultMessage())
                .reduce((m1, m2) -> m1 + ", " + m2)
                .orElse("Validation error");

        return buildApiError(HttpStatus.BAD_REQUEST, message, request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e,
            HttpServletRequest request)
    {
        return buildApiError(HttpStatus.BAD_REQUEST, e, request);
    }

    // ==== GENERIC FAILURES ===============================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(
            Exception e,
            HttpServletRequest request)
    {
        e.printStackTrace();
        return buildApiError(HttpStatus.INTERNAL_SERVER_ERROR, e, request);
    }

    private ResponseEntity<ApiError> buildApiError(
            HttpStatus status,
            Exception e,
            HttpServletRequest request)
    {
        return ResponseEntity.status(status).body(ApiError.from(status, e, request));
    }

    private ResponseEntity<ApiError> buildApiError(
            HttpStatus status,
            String message,
            HttpServletRequest request)
    {
        return ResponseEntity.status(status).body(ApiError.from(status, message, request.getRequestURI()));
    }

}
