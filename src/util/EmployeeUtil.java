package util;

import entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class EmployeeUtil {

  public static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
  //  Map<String, List<entity.Employee>> resultMap = new HashMap<>();

    Map<String, List<Employee>> resultMap = employeeList.stream()
            .collect(groupingBy(Employee::getJobTitle));
/*    for (int i = 0; i < employeeList.size(); i++) {
      entity.Employee employee = employeeList.get(i);
      List<entity.Employee> employeeSubList = resultMap
          .getOrDefault(employee.getJobTitle(), new ArrayList<>());
      employeeSubList.add(employee);
      resultMap.put(employee.getJobTitle(), employeeSubList);
    }*/
    return resultMap;
  }

  public static double calculateAverageSalary(List<Employee> employeeList) {
    //int sum = 0;
    long count =  employeeList.stream()
            .count();
    double sum =  employeeList.stream()
            .mapToDouble(w ->w.getSalary())
            .sum();
/*    for (entity.Employee employee : employeeList) {
      sum += employee.getSalary();
      count++;
    }*/
    return  sum / count;
  }

  public static List<Employee> filterByName(List<Employee> employeeList, String name) {

/*    for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }*/
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
    /*for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }
    resultList.sort(Comparator.comparing(entity.Employee::getSalary).reversed());*/
    return resultList;
  }

  public static Employee filterByNameAndFindWithMaxSalary(List<Employee> employeeList,
                                                          String name) {
/*    List<entity.Employee> resultList = new ArrayList<>();
    for (var item : employeeList) {
      if (item.getName().equals(name)) {
        resultList.add(item);
      }
    }
    return Collections.max(resultList, Comparator.comparing(entity.Employee::getSalary));*/
    return employeeList.stream()
            .filter(w -> w.getName().equals(name))
            .max(Comparator.comparing(Employee::getSalary))
            .orElseThrow(NoSuchElementException::new);
  }
}
