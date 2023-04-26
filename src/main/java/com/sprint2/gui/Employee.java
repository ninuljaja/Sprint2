package com.sprint2.gui;

public abstract class Employee {
    private int employeeID;
    private String firstName = "";
    private String lastName = "";
    private String username = "";
    private String password = "";
    private String middleInitial;
    private String phoneNum;
    private String address;
    private String position;

    private float salary;
    private int SSN;
    public Employee(String[] user){
        try{
            employeeID = Integer.parseInt(user[0]);
            firstName = user[1];
            middleInitial = user[2];
            lastName = user[3];
            phoneNum = user[4];
            address = user[5];
            position = user[6];
            username = user[7];
            password = user[8];
            salary = Float.parseFloat(user[9]);
            SSN = Integer.parseInt(user[10]);
        } catch (NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public int getEmployeeID(){
        return employeeID;
    }
    public String getPosition(){
        return position;
    }
}
