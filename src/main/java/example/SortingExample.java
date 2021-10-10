package example;

import beans.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {
        Employee e1 = new Employee("Dilip", "Kaushalye", "Aurangabad", 5000, 35);
        Employee e2 = new Employee("Advik", "Kaushalye", "Pune", 2000, 25);
        Employee e3 = new Employee("Sam", "Sheikh", "Nagar", 10000, 30);
        Employee e4 = new Employee("Advik", "Kaushalye", "Nasik", 1000, 22);

        List<Employee> employeeList = Arrays.asList(e1, e2, e3, e4);

        //sortByFirstName(employeeList);
        //sortByFirstNameAndCity(employeeList);
        //sortBySalary(employeeList);
        sortBySalaryDesc(employeeList);
    }

    /*
    sort list of employee by first name
     */
    public static void sortByFirstName(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparing(Employee:: getFirstName));

        employeeList.forEach(x-> System.out.println(x));
    }

    /*
    sort list of employees by first name and city name
     */
    public static void sortByFirstNameAndCity(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparing(Employee:: getFirstName).thenComparing(Employee::getCity));

        employeeList.forEach(x-> System.out.println(x));
    }

    /*
    sort list of employees by salary
     */
    public static void sortBySalary(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparing(Employee:: getSalary));

        employeeList.forEach(x-> System.out.println(x));
    }

    /*
    sort list of employees by salary descending
     */
    public static void sortBySalaryDesc(List<Employee> employeeList) {
        employeeList.sort(Comparator.comparing(Employee:: getSalary).reversed());

        employeeList.forEach(x-> System.out.println(x));
    }
}
