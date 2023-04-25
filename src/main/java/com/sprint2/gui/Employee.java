package com.sprint2.gui;

public abstract class Employee {
    private String firstName = "";
    private String lastName = "";
    private String login = "";
    private String password = "";
    private String ID;
    public Employee(String[] user){
        ID = user[0];
        firstName = user[1];
        lastName = user[2];
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public String getEmployeeID(){
        return ID;
    }
}
