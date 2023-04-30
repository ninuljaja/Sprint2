package com.sprint2.gui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ProfileEditorController {

    LoaderManager lm = new LoaderManager();

    @FXML
    TextField firstNameField, middleInitialField, lastNameField, phoneField, addressField, usernameField, passwordField, salaryField, ssnField;
    @FXML
    ChoiceBox<String> roleDropdown;

    public void initialize()
    {
        // TODO: set dropdown values
    }

    @FXML
    protected void onSave() throws IOException
    {
        System.out.println("save profile");
        // TODO: create new employee
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

}
