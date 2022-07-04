package com.example.rqchallenge;

public enum EmployeeConstants {
  NAME ("name"),
  SALARY ("salary"),
  AGE ("age");

  String type;

  EmployeeConstants(String type){
    this.type = type;
  }

  public String getValue(){
    return this.type;
  }

}
