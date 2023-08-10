package com.food;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main{
    static List<Integer> integer = List.of(10,20,30,40);
    public static void main(String[] args){
        integer.stream().filter(i->i%2==0).map(integer1 -> integer1*integer1).forEach(integer1 -> System.out.println(integer1));
    }
}

class Employee{

    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Employee(Integer id, String firstName, String lastName, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public static void main(String[] args) {
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1,"Shailesh","Darji",LocalDate.of(2001,06,13)));
//       List<EmployeeResponse> employeeResponses= employees.stream().map(i->new EmployeeResponse(i.getFirstName()+" "+(i.getLastName()),LocalDate.now().getYear()-i.getDob().getYear())).collect(Collectors.toList());
//        System.out.println(employeeResponses);

        List<Integer> input = List.of(2,4,3,3,6,0,2,4,10);
        int sum=4;
        Map<Integer, Integer> addPair = new HashMap<>();
        IntStream.range(0,input.size()).forEach(i->{
            if(addPair.containsKey(input.get(i))) {
                if (!addPair.containsKey(sum - input.get(i))) {
                    addPair.remove(sum - input.get(i));
                }
            }
            else {
                if(sum-input.get(i)>=0) {
                    addPair.put(input.get(i), sum - input.get(i));
                }


            }
            }
        );
        addPair.entrySet().forEach(i-> System.out.println(i.getKey()+","+i.getValue()));
    }

}


class EmployeeResponse{
    private String fullName;
    private int age;

    public EmployeeResponse(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeResponse{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}