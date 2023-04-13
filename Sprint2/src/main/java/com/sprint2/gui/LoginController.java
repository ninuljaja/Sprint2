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

  //      FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
    //    loader.setController(this);
    //    Parent root = loader.load();

 //       stage = new Stage();
   //     stage.setScene(new Scene(root));
     //   stage.show();

     /*   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Table-layout.fxml"));
        AnchorPane root2 = fxmlLoader.load();
        Scene scene = new Scene(root2);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.show();*/
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Table-layout.fxml"));
        loginAs.getChildren().setAll(pane);
    }
/*

    public void onTableA1(ActionEvent actionEvent) {
    }

    public void onTableA2(ActionEvent actionEvent) {
    }

    public void onTableB1(ActionEvent actionEvent) {
    }

    public void onTableB2(ActionEvent actionEvent) {
    }

    public void onTableA3(ActionEvent actionEvent) {
    }

    public void onTableB3(ActionEvent actionEvent) {
    }

    public void onTableA4(ActionEvent actionEvent) {
    }

    public void onTableB4(ActionEvent actionEvent) {
    }

    public void onTableA5(ActionEvent actionEvent) {
    }

    public void onTableB5(ActionEvent actionEvent) {
    }

    public void onTableA6(ActionEvent actionEvent) {
    }

    public void onTableB6(ActionEvent actionEvent) {
    }

    public void onTableC5(ActionEvent actionEvent) {
    }

    public void onTableD5(ActionEvent actionEvent) {
    }

    public void onTableC6(ActionEvent actionEvent) {
    }

    public void onTableD6(ActionEvent actionEvent) {
    }

    public void onTableE1(ActionEvent actionEvent) {
    }

    public void onTableF1(ActionEvent actionEvent) {
    }

    public void onTableE2(ActionEvent actionEvent) {
    }

    public void onTableF2(ActionEvent actionEvent) {
    }

    public void onTableE3(ActionEvent actionEvent) {
    }

    public void onTableF3(ActionEvent actionEvent) {
    }

    public void onTableE4(ActionEvent actionEvent) {
    }

    public void onTableF4(ActionEvent actionEvent) {
    }

    public void onTableE5(ActionEvent actionEvent) {
    }

    public void onTableF5(ActionEvent actionEvent) {
    }

    public void onTableE6(ActionEvent actionEvent) {
    }

    public void onTableF6(ActionEvent actionEvent) {
    }

    public void onGoBack(ActionEvent actionEvent) {
    }

    public void onPlaceOrderBtn(ActionEvent actionEvent) {
    }*/
}