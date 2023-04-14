package com.sprint2.gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LoginAsController {

    @FXML
    private Button managerButton, waitButton, kitchenButton, busButton, hostButton;
    @FXML
    private Label welcomeLabel;
    @FXML
    private AnchorPane loginAs;
    private Employee user;


    public LoginAsController(){

    }

    public void setUser(Employee user){
        this.user = user;
        welcomeLabel.setText("Welcome, " + user.getFirstName()+ " " + user.getLastName() + "\nLog in as…");
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
    protected void onWaiterButton() throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Table-layout.fxml"));
        loginAs.getChildren().setAll(pane);
    }
}
