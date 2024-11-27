package com.example.employeedb.helpers;

import ch.qos.logback.core.subst.Token;
import com.example.employeedb.entity.Employee;
import com.example.employeedb.input.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeHelper implements Helper<Employee> {
    @Autowired
    private Input input;
    @Override
    public Optional<Employee> create() {
        try{
            System.out.println("=====Создание работника=====");
            Employee employee = new Employee();
            System.out.println("Имя: ");
            employee.setFirstname(input.nextLine());
            System.out.println("Фамилия: ");
            employee.setLastname(input.nextLine());
            System.out.println("Должность: ");
            employee.setPosition(input.nextLine());
            System.out.println("Зарплата: ");
            employee.setSalary(input.nextLine());

            return Optional.of(employee);
        }catch (Exception e){
            return Optional.empty();
        }

    }

    @Override
    public boolean printList(List<Employee> employees) {
        if(employees.isEmpty()) {
            System.out.println("Список работников пуст");
            return false;
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.printf("%d. %s %s. %s. %s%n",
                    i+1,
                    employee.getFirstname(),
                    employee.getLastname(),
                    employee.getPosition(),
                    employee.getSalary()
            );
        }
        return true;
    }
}
