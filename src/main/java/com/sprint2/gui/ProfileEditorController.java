package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ProfileEditorController {

    @FXML
    TextField firstNameField, middleInitialField, lastNameField, phoneField, addressField, usernameField, passwordField, salaryField, ssnField;
    @FXML
    ChoiceBox<String> roleDropdown;

    private Employee activeEmployee;
    private boolean isActiveEmployeeNew;

    public void initialize()
    {
        roleDropdown.getItems().setAll("Host", "Waiter", "Cook", "Busser", "Manager");
    }

    @FXML
    protected void onSave() throws IOException
    {
        String alertString = "";
        if (firstNameField.getText().isEmpty())
            alertString += "The employee's first name cannot be empty. ";
        if (lastNameField.getText().isEmpty())
            alertString += "The employee's last name cannot be empty. ";
        if (roleDropdown.getValue() == null || roleDropdown.getValue().isEmpty())
            alertString += "The employee's role cannot be empty. ";
        if (usernameField.getText().isEmpty())
            alertString += "The employee's username cannot be empty. ";
        if (passwordField.getText().isEmpty())
            alertString += "The employee's password cannot be empty. ";
        
        if (!alertString.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, alertString);
            alert.setHeaderText("Missing Employee Information");
            alert.showAndWait();
            return;
        }

        UpdateEmployee(activeEmployee);
        if (isActiveEmployeeNew)
        {
            GUIApplication.getEmployeeDatabase().addEmployee(activeEmployee);
        } else {
            GUIApplication.getEmployeeDatabase().saveToFile();
        }
        LoaderManager.LoadScreen("EmployeeProfile-view.fxml");
    }

    @FXML
    protected void onCancel(ActionEvent actionEvent) throws IOException
    {
        LoaderManager.LoadScreen("EmployeeProfile-view.fxml");
    }

    @FXML
    protected void onGoBackBtn() throws IOException
    {
        LoaderManager.LoadScreen("EmployeeProfile-view.fxml");
    }

    public void CreateEmployee()
    {
        Employee newEmployee = new Employee();
        LoadEmployee(newEmployee);
        isActiveEmployeeNew = true;
    }

    public void LoadEmployee(Employee employee)
    {
        isActiveEmployeeNew = false;
        activeEmployee = employee;
        firstNameField.setText(employee.getFirstName());
        lastNameField.setText(employee.getLastName());
        middleInitialField.setText(employee.getMiddleInitial());
        phoneField.setText(employee.getPhoneNum());
        addressField.setText(employee.getAddress());
        usernameField.setText(employee.getUsername());
        passwordField.setText(employee.getPassword());
        roleDropdown.setValue(employee.getPosition());
        salaryField.setText(Float.toString(employee.getSalary()));
        ssnField.setText(Integer.toString(employee.getSSN()));
    }

    private void UpdateEmployee(Employee employee)
    {
        employee.setFirstName(firstNameField.getText());
        employee.setLastName(lastNameField.getText());
        employee.setMiddleInitial(middleInitialField.getText());
        employee.setPhoneNum(phoneField.getText());
        employee.setAddress(addressField.getText().replaceAll(",",";"));
        employee.setUsername(usernameField.getText());
        employee.setPassword(passwordField.getText());
        employee.setPosition(roleDropdown.getValue());

        if (!salaryField.getText().isEmpty()) {
            employee.setSalary(Float.parseFloat(salaryField.getText()));
        } else {
            employee.setSalary(0f);
        }
        if (!ssnField.getText().isEmpty()) {
            employee.setSSN(Integer.parseInt(ssnField.getText()));
        } else {
            employee.setSSN(0);
        }
    }
}
