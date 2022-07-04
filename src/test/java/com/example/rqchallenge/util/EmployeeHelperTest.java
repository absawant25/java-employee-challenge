package com.example.rqchallenge.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.rqchallenge.models.Employee;
import com.example.rqchallenge.models.EmployeeList;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmployeeHelper.class})
@ExtendWith(SpringExtension.class)
class EmployeeHelperTest {

  @Autowired
  private EmployeeHelper employeeHelper;

  @MockBean
  private EmployeeList employeeList;

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  void testFilterByName() {
    EmployeeList employeeList1 = new EmployeeList();
    ArrayList<Employee> employeeList2 = new ArrayList<>();
    employeeList1.setEmployeeList(employeeList2);
    employeeList1.setStatus("Status");
    assertEquals(employeeList2, employeeHelper.filterByName(employeeList1, "Employee Name").getEmployeeList());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  void testFilterByName2() {
    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList.setEmployeeList(employeeList1);
    employeeList.setStatus("Status");
    assertEquals(employeeList1, employeeHelper.filterByName(employeeList, "Employee Name").getEmployeeList());
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  void testFilterByName3() {
    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(new Employee(1, "Name", 1L, 1, "Profile image"));
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    ArrayList<Employee> employeeList2 = new ArrayList<>();
    employeeList.setEmployeeList(employeeList2);
    employeeList.setStatus("Status");
    assertEquals(employeeList2, employeeHelper.filterByName(employeeList, "Employee Name").getEmployeeList());
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  void testFilterByName4() {
    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(new Employee(1, "Name", 5L, 5, "Profile image"));
    employeeList1.add(new Employee(1, "Name", 1L, 1, "Profile image"));
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    ArrayList<Employee> employeeList2 = new ArrayList<>();
    employeeList.setEmployeeList(employeeList2);
    employeeList.setStatus("Status");
    assertEquals(employeeList2, employeeHelper.filterByName(employeeList, "Employee Name").getEmployeeList());
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterByName5() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "String.contains(java.lang.CharSequence)" because the return value of "com.example.rqchallenge.models.Employee.getName()" is null
    //       at com.example.rqchallenge.util.EmployeeHelper.lambda$filterByName$0(EmployeeHelper.java:28)
    //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterByName(EmployeeHelper.java:29)
    //   In order to prevent filterByName(EmployeeList, String)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterByName(EmployeeList, String).
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(new Employee());
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.filterByName(employeeList, "Employee Name");
  }

  /**
   * Method under test: {@link EmployeeHelper#filterByName(EmployeeList, String)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterByName6() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "com.example.rqchallenge.models.Employee.getName()" because "employee" is null
    //       at com.example.rqchallenge.util.EmployeeHelper.lambda$filterByName$0(EmployeeHelper.java:28)
    //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterByName(EmployeeHelper.java:29)
    //   In order to prevent filterByName(EmployeeList, String)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterByName(EmployeeList, String).
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(null);
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.filterByName(employeeList, "Employee Name");
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterById() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
    //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
    //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
    //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
    //       at java.util.Objects.checkIndex(Objects.java:359)
    //       at java.util.ArrayList.get(ArrayList.java:427)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterById(EmployeeHelper.java:37)
    //   In order to prevent filterById(EmployeeList, int)
    //   from throwing IndexOutOfBoundsException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterById(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    EmployeeList employeeList1 = new EmployeeList();
    employeeList1.setEmployeeList(new ArrayList<>());
    employeeList1.setStatus("Status");
    employeeHelper.filterById(employeeList1, 1);
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterById2() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
    //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
    //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
    //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
    //       at java.util.Objects.checkIndex(Objects.java:359)
    //       at java.util.ArrayList.get(ArrayList.java:427)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterById(EmployeeHelper.java:37)
    //   In order to prevent filterById(EmployeeList, int)
    //   from throwing IndexOutOfBoundsException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterById(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.filterById(employeeList, 1);
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  void testFilterById3() {
    ArrayList<Employee> employeeList1 = new ArrayList<>();
    Employee employee = new Employee(1, "Name", 1L, 1, "Profile image");

    employeeList1.add(employee);
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    assertSame(employee, employeeHelper.filterById(employeeList, 1));
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  void testFilterById4() {
    ArrayList<Employee> employeeList1 = new ArrayList<>();
    Employee employee = new Employee(1, "Name", 1L, 1, "Profile image");

    employeeList1.add(employee);
    employeeList1.add(new Employee(1, "Name", 1L, 1, "Profile image"));
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    assertSame(employee, employeeHelper.filterById(employeeList, 1));
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterById5() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
    //       at jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
    //       at jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
    //       at jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
    //       at java.util.Objects.checkIndex(Objects.java:359)
    //       at java.util.ArrayList.get(ArrayList.java:427)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterById(EmployeeHelper.java:37)
    //   In order to prevent filterById(EmployeeList, int)
    //   from throwing IndexOutOfBoundsException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterById(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(new Employee());
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.filterById(employeeList, 1);
  }

  /**
   * Method under test: {@link EmployeeHelper#filterById(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testFilterById6() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException: Cannot invoke "com.example.rqchallenge.models.Employee.getId()" because "emp" is null
    //       at com.example.rqchallenge.util.EmployeeHelper.lambda$filterById$1(EmployeeHelper.java:36)
    //       at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:178)
    //       at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
    //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //       at com.example.rqchallenge.util.EmployeeHelper.filterById(EmployeeHelper.java:37)
    //   In order to prevent filterById(EmployeeList, int)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   filterById(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(null);
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.filterById(employeeList, 1);
  }

  /**
   * Method under test: {@link EmployeeHelper#getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)}
   */
  @Test
  void testGetNNumberOfHigeshestPayingEmployeeName() {
    EmployeeList employeeList1 = new EmployeeList();
    employeeList1.setEmployeeList(new ArrayList<>());
    employeeList1.setStatus("Status");
    assertTrue(employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList1, 1).isEmpty());
  }

  /**
   * Method under test: {@link EmployeeHelper#getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)}
   */
  @Test
  void testGetNNumberOfHigeshestPayingEmployeeName2() {
    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    assertTrue(employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList, 1).isEmpty());
    verify(employeeList).getEmployeeList();
    verify(employeeList).setEmployeeList((List<Employee>) any());
    verify(employeeList).setStatus((String) any());
  }

  /**
   * Method under test: {@link EmployeeHelper#getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetNNumberOfHigeshestPayingEmployeeName3() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: -1
    //       at java.util.stream.ReferencePipeline.limit(ReferencePipeline.java:568)
    //       at com.example.rqchallenge.util.EmployeeHelper.getNNumberOfHigeshestPayingEmployeeName(EmployeeHelper.java:45)
    //   In order to prevent getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)
    //   from throwing IllegalArgumentException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList, -1);
  }

  /**
   * Method under test: {@link EmployeeHelper#getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testGetNNumberOfHigeshestPayingEmployeeName4() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
    //       at java.util.stream.SliceOps$1$1.accept(SliceOps.java:200)
    //       at java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:361)
    //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:528)
    //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:513)
    //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    //       at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    //       at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    //       at com.example.rqchallenge.util.EmployeeHelper.getNNumberOfHigeshestPayingEmployeeName(EmployeeHelper.java:46)
    //   In order to prevent getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int)
    //   from throwing NullPointerException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   getNNumberOfHigeshestPayingEmployeeName(EmployeeList, int).
    //   See https://diff.blue/R013 to resolve this issue.

    ArrayList<Employee> employeeList1 = new ArrayList<>();
    employeeList1.add(null);
    when(employeeList.getEmployeeList()).thenReturn(employeeList1);
    doNothing().when(employeeList).setEmployeeList((List<Employee>) any());
    doNothing().when(employeeList).setStatus((String) any());
    employeeList.setEmployeeList(new ArrayList<>());
    employeeList.setStatus("Status");
    employeeHelper.getNNumberOfHigeshestPayingEmployeeName(employeeList, 1);
  }

  /**
   * Method under test: {@link EmployeeHelper#addNewEmployee(Map)}
   */
  @Test
  void testAddNewEmployee() {
    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());
    employeeHelper.addNewEmployee(new HashMap<>());
    verify(employeeList, atLeast(1)).getEmployeeList();
  }

  /**
   * Method under test: {@link EmployeeHelper#addNewEmployee(Map)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testAddNewEmployee2() {
    // TODO: Complete this test.
    //   Reason: R013 No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.IllegalArgumentException: No enum constant com.example.rqchallenge.EmployeeConstants.EMPLOYEE COUNT AFTER UPDATE : {}
    //       at java.lang.Enum.valueOf(Enum.java:273)
    //       at com.example.rqchallenge.EmployeeConstants.valueOf(EmployeeConstants.java:3)
    //       at com.example.rqchallenge.util.EmployeeHelper.lambda$addNewEmployee$2(EmployeeHelper.java:55)
    //       at java.util.HashMap$KeySet.forEach(HashMap.java:1008)
    //       at com.example.rqchallenge.util.EmployeeHelper.addNewEmployee(EmployeeHelper.java:54)
    //   In order to prevent addNewEmployee(Map)
    //   from throwing IllegalArgumentException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   addNewEmployee(Map).
    //   See https://diff.blue/R013 to resolve this issue.

    when(employeeList.getEmployeeList()).thenReturn(new ArrayList<>());

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("Employee count after update : {}", "Value");
    employeeHelper.addNewEmployee(stringObjectMap);
  }
}

