package entity;

public class Employee {

  private String name;
  private String jobTitle;
  private Double salary;

  public String getJobTitle() {
    return jobTitle;
  }

  public Double getSalary() {
    return salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "entity.Employee{" +
        "name='" + name + '\'' +
        ", jobTitle='" + jobTitle + '\'' +
        ", salary=" + salary +
        '}';
  }

  public static class Builder {

    private Employee employee;

    public Builder() {
      employee = new Employee();
    }

    public Builder setName(String name) {
      employee.name = name;
      return this;
    }

    public Builder setJobTitle(String jobTitle) {
      employee.jobTitle = jobTitle;
      return this;
    }

    public Builder setSalary(Double salary) {
      employee.salary = salary;

      return this;
    }

    public Employee build() {
      return employee;
    }
  }
}
