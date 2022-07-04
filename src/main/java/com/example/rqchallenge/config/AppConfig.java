package com.example.rqchallenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Value("${externalUrl}")
  private String externalWebServiceUrl;

  public String getExternalWebServiceUrl() {
    return externalWebServiceUrl;
  }


}
