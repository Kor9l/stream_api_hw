import entity.Employee;

import static util.EmployeeUtil.calculateAverageSalary;
import static util.EmployeeUtil.filterByName;
import static util.EmployeeUtil.filterByNameAndFindWithMaxSalary;
import static util.EmployeeUtil.groupByJobTitle;
import static util.EmployeeUtil.filterByNameAndSortBySalaryDesc;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";

    Employee employee = new Employee.Builder()
        .setName("Ivan")
        .setJobTitle("programmer")
        .setSalary(870.0).build();

    Employee employee2 = new Employee.Builder()
        .setName("Pavel")
        .setJobTitle("programmer")
        .setSalary(1090.0).build();

    Employee employee3 = new Employee.Builder()
        .setName("Dima")
        .setJobTitle("programmer")
        .setSalary(1489.0).build();

    Employee employee4 = new Employee.Builder()
        .setName("Ivan")
        .setJobTitle("plumber")
        .setSalary(979.0).build();

    Employee employee5 = new Employee.Builder()
        .setName("Dima")
        .setJobTitle("plumber")
        .setSalary(569.0).build();

    Employee employee6 = new Employee.Builder()
        .setName("Michael")
        .setJobTitle("driver")
        .setSalary(678.0).build();

    Employee employee7 = new Employee.Builder()
        .setName("Ivan")
        .setJobTitle("driver")
        .setSalary(478.0).build();

    Employee employee8 = new Employee.Builder()
        .setName("Ivan")
        .setJobTitle("plumber")
        .setSalary(569.0).build();

    List<Employee> employees = new ArrayList<>() {
      {
        add(employee);
        add(employee2);
        add(employee3);
        add(employee4);
        add(employee5);
        add(employee6);
        add(employee7);
        add(employee8);
      }
    };

    for (var item : groupByJobTitle(employees).values()) {
      System.out.println(ANSI_GREEN + item);
    }

    System.out.println(ANSI_PURPLE + calculateAverageSalary(employees));

    for (var item : filterByName(employees, "Ivan")) {
      System.out.println(ANSI_CYAN + item);
    }

    for (var item : filterByNameAndSortBySalaryDesc(employees, "Ivan")) {
      System.out.println(ANSI_YELLOW + item);
    }

    System.out.println(ANSI_BLUE + filterByNameAndFindWithMaxSalary(employees, "Ivan"));
  }
}
