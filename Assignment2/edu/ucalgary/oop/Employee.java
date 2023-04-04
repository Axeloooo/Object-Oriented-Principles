package edu.ucalgary.oop;

public class Employee {
  private String name;
  private final String IDNUMBER;
  private String managerId;
  private Employee[] supervisedEmployees;

  public Employee(String name, String idNumber) {
    this.name = name;
    this.IDNUMBER = idNumber;
  }

  public Employee(String name, String idNumber, String managerId) {
    this.name = name;
    this.IDNUMBER = idNumber;
    this.managerId = managerId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIDNumber() {
    return this.IDNUMBER;
  }

  public String getManagerId() {
    return this.managerId;
  }

  public void setManagerId(String newManager) {
    this.managerId = newManager;
  }

  public void addEmployee(Employee newEmployee) {
    if (this.supervisedEmployees == null) {
      this.supervisedEmployees = new Employee[1];
      this.supervisedEmployees[0] = newEmployee;
    } else {
      Employee[] temp = new Employee[this.supervisedEmployees.length + 1];
      System.arraycopy(this.supervisedEmployees, 0, temp, 0, this.supervisedEmployees.length);
      temp[this.supervisedEmployees.length] = newEmployee;
      this.supervisedEmployees = temp;
    }
  }

  public Employee[] getEmployees() {
    return this.supervisedEmployees;
  }
}
