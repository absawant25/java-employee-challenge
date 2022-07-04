package com.example.rqchallenge.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.rqchallenge.models.Employee;
import com.example.rqchallenge.models.EmployeeList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeHelper.class, EmployeeList.class})
@ExtendWith(SpringExtension.class)
class EmployeeHelperTest {

  @Autowired
  private EmployeeHelper employeeHelper;

  @Autowired
  private EmployeeList employeeList;

  @MockBean
  private EmployeeList employeeList1;

  @Value("classpath:employees.json")
  Resource resourceFile;

  @BeforeEach
  public void setUp() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    employeeList = objectMapper.readValue(resourceFile.getFile(), EmployeeList.class);
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  void testFilterByName() throws IOException {
    assertEquals(1, employeeHelper.filterByName(employeeList, "Tiger").getEmployeeList().stream().count());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  void testFilterById() throws IOException {
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("Tiger Nixon");
    emp.setSalary(320800);
    emp.setAge(61);
    emp.setProfile_image("");
    assertEquals(emp, employeeHelper.filterById(employeeList, 1));
  }


  /**
   * Method under test: {@link EmployeeHelper#getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)}
   */
  @Test
  void testGetNNumberOfHigeshestPayingEmployeeName() throws IOException {
    assertEquals(10, employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList, 10).size());
  }
  /**
   * Method under test: {@link EmployeeHelper#addNewEmployee(Map)}
   */
  @Test
  void testAddNewEmployee() {
    when(employeeList1.getEmployeeList()).thenReturn(new ArrayList<>());
    Map<String, Object> emp = new HashMap<>();
    emp.put("name", "Abhishek");
    emp.put("salary", "10000");
    emp.put("age", "36");
    employeeHelper.addNewEmployee(emp);
    verify(employeeList1, atLeast(1)).getEmployeeList();
  }
}

