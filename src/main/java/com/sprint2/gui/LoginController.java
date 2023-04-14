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
    private Button managerButton, waitButton, kitchenButton, busButton, hostButton;
    @FXML
    private Label welcomeLabel;
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
        String[] result= Authentication.authenticateUser(userName, pass);

        if(result != null)
        {
            tries = 0;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
                loader.setController(this);
                Parent root = loader.load();


                stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                System.err.println(String.format("Error: %s", e.getMessage()));
            }
            welcomeLabel.setText("Welcome, " + result[0] + " " + result[1] + "\nLog in as…");
            String role = result[2].toLowerCase();
            switch (role) {
                case "manager":
                   Manager manager = new Manager();

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
        }
        else
        {
            passwordField.clear();
            tries++;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (tries == 3){
                alert.setContentText("You entered the wrong password 3 time. System is closing");
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
    protected void onLogOutButton() throws IOException {
        //

             Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to log out?", ButtonType.YES);
             alert.setHeaderText("");
             alert.showAndWait();

             if (alert.getResult() == ButtonType.YES){
                 System.exit(0);
             }
    }
    @FXML
    protected void onCancelButton(){
        System.exit(0);
    }

    @FXML
    protected void onWaiterButton() throws IOException {

  
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Table-layout.fxml"));
        loginAs.getChildren().setAll(pane);
    }

}
