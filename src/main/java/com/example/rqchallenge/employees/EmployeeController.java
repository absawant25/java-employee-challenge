package com.example.rqchallenge.employees;

import com.example.rqchallenge.models.Employee;
import com.example.rqchallenge.models.EmployeeList;
import com.example.rqchallenge.util.EmployeeHelper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController implements IEmployeeController {

  @Autowired
  EmployeeHelper employeeHelper;

  @Autowired
  EmployeeList employeeList;

  Logger log = LoggerFactory.getLogger(EmployeeController.class);


  @Override
  public ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
    log.debug("Response : {}", employeeList.getEmployeeList());
    return new ResponseEntity<List<Employee>>(employeeList.getEmployeeList(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Employee>> getEmployeesByNameSearch(String searchString) {
    log.debug("Response : {}", employeeList.getEmployeeList());
    return new ResponseEntity<List<Employee>>(employeeHelper.filterByName(employeeList, searchString).getEmployeeList(),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Employee> getEmployeeById(String id) {
    log.debug("Response : {}", employeeList.getEmployeeList());

    return new ResponseEntity<Employee>(employeeHelper.filterById(employeeList, Integer.valueOf(id)), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
    log.debug("Response : {}", employeeList.getEmployeeList());

    Long maxSalary = employeeList.getEmployeeList().stream().map(Employee::getSalary).max(Long::compare).get();

    return new ResponseEntity<Integer>(maxSalary.intValue(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
    log.info("Response : {}", employeeList.getEmployeeList());
    return new ResponseEntity<List<String>>(employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList, 10),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Employee> createEmployee(Map<String, Object> employeeInput) {
    log.info("Employee count before update : {}", employeeList.getEmployeeList().stream().count());
    return new ResponseEntity<Employee>(employeeHelper.addNewEmployee(employeeInput), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<String> deleteEmployeeById(String id) {
    log.info("Deleting employee with id : {}", id);
    Predicate<Employee> toDelete = emp -> emp.getId() != Integer.valueOf(id);
    employeeList.setEmployeeList(employeeList.getEmployeeList().stream().filter(toDelete).collect(Collectors.toList()));

    return new ResponseEntity<String>("successfully! deleted Record", HttpStatus.OK);
  }
}
