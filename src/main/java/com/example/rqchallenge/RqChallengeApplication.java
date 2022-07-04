package com.example.rqchallenge;

import com.example.rqchallenge.config.AppConfig;
import com.example.rqchallenge.models.EmployeeList;
import com.example.rqchallenge.util.EmployeeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RqChallengeApplication {

  @Autowired
  AppConfig appConfig;

  @Bean
  public EmployeeList getEmployeeList() {
    RestTemplate restTemplate = new RestTemplate();

    EmployeeList employeeList = restTemplate.getForObject(appConfig.getExternalWebServiceUrl().trim(),
        EmployeeList.class);

    return employeeList;
  }

  @Bean
  public EmployeeHelper getEmployeeHelper() { return new EmployeeHelper(); }

  public static void main(String[] args) {
    SpringApplication.run(RqChallengeApplication.class, args);
  }

}
