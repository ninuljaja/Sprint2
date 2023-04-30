package com.sprint2.gui;

public class Employee {
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
            ex.printStackTrace();
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

    private Employee() {
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


    public static class Builder
    {
        protected int employeeID = -1;
        private String firstName = "";
        private String lastName = "";
        private String username = "";
        private String password = "";
        private String middleInitial = "";
        private String phoneNum = "";
        private String address = "";
        private String position = "";
        private float salary = 0f;
        private int SSN = 0;

        public Employee build()
        {
            Employee employee = new Employee();
            employee.employeeID = -1;
            employee.firstName = firstName;
            employee.lastName = lastName;
            employee.username = username;
            employee.password = password;
            employee.middleInitial = middleInitial;
            employee.phoneNum = phoneNum;
            employee.address = address;
            employee.position = position;
            employee.salary = salary;
            employee.SSN = SSN;
            return employee;
        }

        public Employee.Builder withFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Employee.Builder withLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Employee.Builder withMiddleInitial(String middleInitial)
        {
            this.middleInitial = middleInitial;
            return this;
        }

        public Employee.Builder withUsername(String username)
        {
            this.username = username;
            return this;
        }

        public Employee.Builder withPassword(String password)
        {
            this.password = password;
            return this;
        }

        public Employee.Builder withPhoneNum(String phoneNum)
        {
            this.phoneNum = phoneNum;
            return this;
        }

        public Employee.Builder withAddress(String address)
        {
            this.address = address;
            return this;
        }

        public Employee.Builder withPosition(String position)
        {
            this.position = position;
            return this;
        }

        public Employee.Builder withSalary(float salary)
        {
            this.salary = salary;
            return this;
        }

        public Employee.Builder withSSN(int ssn)
        {
            this.SSN = ssn;
            return this;
        }
    }
}
