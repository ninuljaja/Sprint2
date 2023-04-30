package com.sprint2.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ProfileEditorController {

    @FXML
    TextField firstNameField, middleInitialField, lastNameField, phoneField, addressField, usernameField, passwordField, salaryField, ssnField;
    @FXML
    ChoiceBox<String> roleDropdown;

    private Employee activeEmployee;

    public void initialize()
    {
        roleDropdown.getItems().setAll("Host", "Waiter", "Cook", "Busser", "Manager");
    }

    @FXML
    protected void onSave() throws IOException
    {
        System.out.println("save profile");
        // TODO: create new employee
        System.out.println(CreateEmployee());
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

    private Employee CreateEmployee()
    {
        Employee.Builder builder = new Employee.Builder();
        builder = builder
            .withFirstName(firstNameField.getText())
            .withLastName(lastNameField.getText())
            .withMiddleInitial(middleInitialField.getText())
            .withPhoneNum(phoneField.getText())
            .withAddress(addressField.getText())
            .withUsername(usernameField.getText())
            .withPassword(passwordField.getText())
            .withPosition(roleDropdown.getValue());

        if (!salaryField.getText().isEmpty()) {
            builder = builder.withSalary(Float.parseFloat(salaryField.getText()));
        }
        if (!ssnField.getText().isEmpty()) {
            builder = builder.withSSN(Integer.parseInt(ssnField.getText()));
        }

        return builder.build();
    }

    public void LoadEmployee(Employee employee)
    {
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

}
