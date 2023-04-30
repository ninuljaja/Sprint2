package com.sprint2.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDatabase {
    private List<Employee> employees = new ArrayList<Employee>();
    private String header = "Employee ID,FirstName,MiddleInitial,LastName,Phone#,Address,Role,username,password,wage ($ per hour),SSN";

    public List<Employee> getEmployees()
    {
        return employees;
    }

    public void loadFromFile(String filename) {
        File employeeDatabaseFile = new File(filename);
        try {
            Scanner scan = new Scanner(employeeDatabaseFile);
            if (!scan.hasNextLine()) {
                scan.close();
                return;
            }
            scan.nextLine();
            while (scan.hasNextLine())
            {
                String serializedEmployee = scan.nextLine();
                Employee employee = Employee.deserialize(serializedEmployee);
                employees.add(employee);
            }
            scan.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }

    public void saveToFile(String filename)
    {
        File employeeDatabaseFile = new File(filename);
        FileWriter writer;
        try {
            writer = new FileWriter(employeeDatabaseFile, false);
            writer.write(header + "\n");
            for (Employee employee : employees)
            {
                writer.write(Employee.serialize(employee) + "\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }
}
