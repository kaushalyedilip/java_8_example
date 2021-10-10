package map_flatmap;

import beans.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {

    public static void main(String[] args) {
        //List<Customer> to List<String> --> Data transformation
        //mapping customer.email to email
        List<String> emailIds = getAll().stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(emailIds);

        List<List<String>> list = getAll().stream().map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
        System.out.println(list);

        List<String> phoneNumbers = getAll().stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
        System.out.println(phoneNumbers);
    }

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }
}
