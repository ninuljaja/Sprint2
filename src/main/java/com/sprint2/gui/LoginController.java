package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    int tries = 0;


  Stage stage;

    @FXML
    private Button login;
    @FXML AnchorPane loginPane;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public LoginController() throws IOException {
    }

    @FXML
    protected void onLoginButton() throws IOException {
        String userName = usernameField.getText();
        String pass = passwordField.getText();
        Employee employee = Authentication.authenticateUser(userName, pass);

        if(employee != null)
        {
            tries = 0;
            Session session = Session.getInstance();
            String role = employee.getPosition().toLowerCase();
            employee = employee.asRole();
            session.setUser(employee);
            session.setMode(role);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
                Parent root = loader.load();
                stage = (Stage) login.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            passwordField.clear();
            tries++;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (tries == 3){
                alert.setContentText("You entered the wrong password 3 time. This terminal will be locked. Please contact your manager for assistance.");
                alert.showAndWait();
                alert.setResult(ButtonType.CLOSE);
                if (alert.getResult() == ButtonType.CLOSE)
                    System.exit(0);
            }
            alert.setContentText("Authentication Failed! Please enter a valid username and password");
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onCancelButton(){
        System.exit(0);
    }
    @FXML
    private void onUsernameField(){
        passwordField.requestFocus();
    }
    @FXML
    private void onPasswordField() throws IOException {
        onLoginButton();
    }



}
