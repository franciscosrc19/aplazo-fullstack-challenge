package com.aplazo.msprptakehome.exception;

import com.aplazo.msprptakehome.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
             .body(new ErrorResponse("APZ000002", "INVALID_REQUEST", Instant.now().getEpochSecond(), e.getMessage(), "/v1/customers"));
  }
}
