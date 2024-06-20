package ch8._myexercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {
    private String name;
    private Title jobTitle;
    private int experienceYears;

    public Employee(String name, Title jobTitle, int experienceYears) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.experienceYears = experienceYears;
    }

    enum Title {
        ZOOKEEPER,
        VETERINARIAN,
        ANIMAL_TRAINER,
        GROUNDSKEEPER,
        EDUCATOR,
        ADMINISTRATOR,
        OTHER
    }
    public String getName() {
        return this.name;
    }

    public Title getJobTitle() {
        return this.jobTitle;
    }

    public int getExperienceYears() {
        return this.experienceYears;
    }


    public static void main(String[] args) {

        String[] empNames = {"Joe", "Juan", "Susan", "Bonita", "Shakil"};

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee(empNames[i],
                    Employee.Title.values()[new Random().nextInt(Employee.Title.values().length)],
                    new Random().nextInt(10));
            employees.add(employee);
        }

        System.out.printf("%-15s%-15s%-15s%n", "Name", "Years of Experience", "Title");
        System.out.println("-------------------------------");
        for (Employee emp : employees) {
            System.out.printf("%-15s%-15d%-15s%n", emp.getName(), emp.getExperienceYears(), emp.getJobTitle());
        }
    }
}
