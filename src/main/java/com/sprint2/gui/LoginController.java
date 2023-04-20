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
    private Button login, managerButton, waitButton, kitchenButton, busButton, hostButton;


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

            String role = user[3].toLowerCase();
            switch (role) {
                case "manager":
                    employee = new Manager(user);

                   break;
                case "busser":
                    hostButton.setDisable(true);
                    kitchenButton.setDisable(true);
                    waitButton.setDisable(true);
                    managerButton.setDisable(true);
                  break;
                case "cook":
                    hostButton.setDisable(true);
                    busButton.setDisable(true);
                    waitButton.setDisable(true);
                    managerButton.setDisable(true);

                    break;
                case "server":
                    hostButton.setDisable(true);
                    kitchenButton.setDisable(true);
                    busButton.setDisable(true);
                    managerButton.setDisable(true);

                    break;
                case "host":
                    busButton.setDisable(true);
                    kitchenButton.setDisable(true);
                    waitButton.setDisable(true);
                    managerButton.setDisable(true);

                    break;
            }
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
                Parent root = loader.load();
                LoginAsController loginAsScreenController = loader.getController();
                loginAsScreenController.setUser(employee);
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
