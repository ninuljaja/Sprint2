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
    @FXML
    private AnchorPane loginAs;
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
        String[] user= Authentication.authenticateUser(userName, pass);

        if(user != null)
        {
            tries = 0;
            Employee employee = null;
            Session session = null;
            String role = user[6].toLowerCase();
            switch (role) {
                case "manager":
                    employee = new Manager(user);
                    session = Session.getInstance();
                    session.setUser(employee);
                    session.setMode("manager");
                   break;
                case "busser":
                   //
                  break;
                case "cook":
                    //
                    break;
                case "server":
                    employee = new Waiter(user);
                    session = Session.getInstance();
                    session.setUser(employee);
                    session.setMode("waiter");
                    break;
                case "host":
                    //
                    break;
            }
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
                Parent root = loader.load();
                stage = (Stage) login.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.err.println(String.format("Error: %s", e.getMessage()));
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



}
