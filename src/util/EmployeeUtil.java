package util;

import entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeUtil {

  public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {

    Map<String, List<Employee>> resultMap = employeeList.stream()
            .collect(groupingBy(Employee::getJobTitle));

    return resultMap;
  }

  public static double calculateAverageSalary(List<Employee> employeeList) {

    long count =  employeeList.stream()
            .count();
    double sum =  employeeList.stream()
            .mapToDouble(w ->w.getSalary())
            .sum();

    return  sum / count;
  }

  public static List<Employee> filterByName(List<Employee> employeeList, String name) {



    return employeeList.stream()
            .filter(w->w.getName() == name)
            .collect(Collectors.toList());
  }

  public static List<Employee> filterByNameAndSortBySalaryDesc(List<Employee> employeeList,
                                                               String name) {
    List<Employee> resultList = employeeList.stream()
            .filter(w->w.getName().equals(name))
            .sorted(Comparator.comparing(Employee::getSalary).reversed())
            .collect(Collectors.toList());

    return resultList;
  }

  public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList,
                                                          String name) {
    return employeeList.stream()
            .filter(w -> w.getName().equals(name))
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(NoSuchElementException::new);
  }
}
