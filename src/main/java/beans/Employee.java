package beans;

public class Employee {

    private String firstName;
    private String lastName;
    private String city;
    private double salary;
    private Integer age;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String city, double salary, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.salary = salary;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
