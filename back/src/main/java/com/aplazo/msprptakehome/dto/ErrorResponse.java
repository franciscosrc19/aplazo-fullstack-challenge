package com.aplazo.msprptakehome.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
public class ErrorResponse {

  private String code;
  private String error;
  private long timestamp;
  private String message;
  private String path;

  public ErrorResponse(String code, String error, long timestamp, String message, String path) {
    this.code = code;
    this.error = error;
    this.timestamp = timestamp;
    this.message = message;
    this.path = path;
  }


}
