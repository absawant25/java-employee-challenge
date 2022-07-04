package com.example.rqchallenge.util;

import com.example.rqchallenge.EmployeeConstants;
import com.example.rqchallenge.models.Employee;
import com.example.rqchallenge.models.EmployeeList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeHelper {

  @Autowired
  EmployeeList employeeList;

  Logger log = LoggerFactory.getLogger(EmployeeHelper.class);

  public EmployeeList filterByName(EmployeeList employeeList, String employeeName) {

    EmployeeList employeeList1 = new EmployeeList();

    employeeList1.setEmployeeList(
        employeeList.getEmployeeList().stream().filter(employee -> employee.getName().contains(employeeName))
            .collect(Collectors.toList()));

    return employeeList1;
  }

  public Employee filterById(EmployeeList employeeList, int id) {

    Employee employee = employeeList.getEmployeeList().stream().filter(emp -> emp.getId() == id)
        .collect(Collectors.toList()).get(0);

    return employee;
  }

  public List<String> getNNumberOfHigeshestPayingEmployeeName(EmployeeList employeeList, int n) {

    List<String> empNames = employeeList.getEmployeeList().stream()
        .sorted(Comparator.comparingLong(Employee::getSalary).reversed()).limit(n).map(Employee::getName)
        .collect(Collectors.toList());

    return empNames;

  }

  public Employee addNewEmployee(Map<String, Object> employeeInput) {
    Employee employee = new Employee();
    employeeInput.keySet().forEach(key -> {
      switch (EmployeeConstants.valueOf(key.toUpperCase(Locale.ROOT))) {
        case NAME:
          int id = 0;
          if (!employeeList.getEmployeeList().isEmpty()) {
            id = employeeList.getEmployeeList().stream().map(Employee::getId).max(Integer::compare).get();
          }
          employee.setId(id + 1);

          employee.setName(employeeInput.get(key).toString());
          break;
        case SALARY:
          employee.setSalary(Long.valueOf(String.valueOf(employeeInput.get(key))));
          break;
        case AGE:
          employee.setAge(Integer.valueOf(String.valueOf(employeeInput.get(key))));
          break;
      }
    });

    employeeList.getEmployeeList().add(employee);

    log.info("Employee count after update : {}", employeeList.getEmployeeList().stream().count());

    return employee;
  }

}
