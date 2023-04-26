package com.sprint2.gui;

public abstract class Employee {
    protected int employeeID;
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
    public Employee(Employee user){
        employeeID = user.getEmployeeID();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        middleInitial = user.getMiddleInitial();
        phoneNum = user.getPhoneNum();
        address = user.getAddress();
        position = user.getPosition();
        username = user.getUsername();
        password = user.getPassword();
        salary = user.getSalary();
        SSN = user.getSSN();
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

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public float getSalary() {
        return salary;
    }

    public int getSSN() {
        return SSN;
    }


}
