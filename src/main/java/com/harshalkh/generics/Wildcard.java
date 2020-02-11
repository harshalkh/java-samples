package com.harshalkh.generics;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Wildcard {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        produce(employees);
        consume(employees);
    }

    //Can add any implementation object of Employee to List
    private static void produce(List<? super Employee> employees) {
        PermanentEmployee permanentEmployee1 = new PermanentEmployee("1", "Sagar", "Engineer 1");
        PermanentEmployee permanentEmployee2 = new PermanentEmployee("2", "Ravi", "Engineer 2");
        Contractor contractor = new Contractor("2", "Pravin", new Date());
        employees.add(permanentEmployee1);
        employees.add(permanentEmployee2);
        employees.add(contractor);
    }

    //Can print any object that extends Employee class
    private static void consume(List<? extends Employee> employees) {
        employees.stream()
                .map(Employee::toString)
                .forEach(System.out::println);
    }

    @Getter
    @AllArgsConstructor
    private static class Employee {
        private String id;
        private String name;

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Getter
    private static class PermanentEmployee extends Employee {
        private String designation;

        public PermanentEmployee(String id, String name, String designation) {
            super(id, name);
            this.designation = designation;
        }

        @Override
        public String toString() {
            return "PermanentEmployee{" +
                    "id='" + super.id + '\'' +
                    ", name='" + super.name + '\'' +
                    ", designation='" + designation + '\'' +
                    '}';
        }
    }

    @Getter
    private static class Contractor extends Employee {
        private Date contractEndDate;

        public Contractor(String id, String name, Date contractEndDate) {
            super(id, name);
            this.contractEndDate = contractEndDate;
        }

        @Override
        public String toString() {
            return "Contractor{" +
                    "id='" + super.id + '\'' +
                    ", name='" + super.name + '\'' +
                    ", contractEndDate='" + contractEndDate + '\'' +
                    '}';
        }
    }
}
