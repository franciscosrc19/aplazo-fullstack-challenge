package com.aplazo.msprptakehome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@ComponentScan("com.aplazo")
public class MsdApplication {

  public static void main(String[] args) {
    System.setProperty("name.app", "msprptakehome");
    SpringApplication.run(MsdApplication.class, args);
  }
}
