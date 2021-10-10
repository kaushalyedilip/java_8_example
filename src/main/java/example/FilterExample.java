package example;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterExample {

    public static void main(String[] args) {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Pune", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Abad", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Pune", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Pune", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        //filerEmployee(employeeList);
        //filerEmployeeByCityAndSalary();
        //filerEmployeeByCityAndMaxSal();
        //filerEmployeeByCityAndMinSal();
        filerEmployeeByFirstChar();
    }
    /*
    print the list of employee belongs to city Pune
     */
    public static void filerEmployee(List<Employee> employeeList) {
       List<Employee> employees = employeeList.stream().filter(e1-> "Pune".equals(e1.getCity())).collect(Collectors.toList());
        employees.forEach(System.out::println);
    }

    /*
    print the list of employee belongs to city Pune and salary>5000
     */
    public static void filerEmployeeByCityAndSalary() {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Pune", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Abad", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Pune", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Pune", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        List<Employee> employees = employeeList.stream().filter(e-> "Pune".equals(e.getCity())).filter(e->e.getSalary()>=5000)
                .collect(Collectors.toList());
        employees.forEach(System.out::println);
    }

    /*
   print the employee belongs to city Pune and having highest salary
    */
    public static void filerEmployeeByCityAndMaxSal() {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Pune", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Abad", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Pune", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Pune", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        Optional<Employee> employee = employeeList.stream().filter(e-> "Pune".equals(e.getCity())).max(Comparator.comparing(Employee::getSalary));

        System.out.println(employee.get());
    }

    /*
   print the employee belongs to city Pune and having min salary
    */
    public static void filerEmployeeByCityAndMinSal() {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Pune", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Abad", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Pune", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Pune", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        Optional<Employee> employee = employeeList.stream().filter(e-> "Pune".equals(e.getCity())).min(Comparator.comparing(Employee::getSalary));

        System.out.println(employee.get());
    }

    /*
    print the list of employee who's name starting with A
     */
    public static void filerEmployeeByFirstChar() {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Pune", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Abad", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Pune", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Pune", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);
        List<Employee> employees = employeeList.stream().filter(e-> e.getFirstName().startsWith("A"))
                .collect(Collectors.toList());
        employees.forEach(System.out::println);
    }

}
