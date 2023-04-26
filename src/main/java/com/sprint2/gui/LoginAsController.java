package com.sprint2.gui;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LoginAsController {

    @FXML
    private Button managerButton, waitButton, kitchenButton, busButton, hostButton;

    @FXML
    private Label welcomeLabel;
    @FXML
    private AnchorPane loginAs;

    @FXML
    private Label clockInOutLbl;
     @FXML
    private Button clockInOutButton;
    private ClockLogs record;
    private Employee user;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Session session = null;

    public LoginAsController(){

    }
    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
        switch (user.getPosition().toLowerCase()) {
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
        // Set the username label
        welcomeLabel.setText("Welcome, " + user.getFirstName()+ " " + user.getLastName() + "\nLog in as…");
        record = ClockLogManager.getClockLog();
        clockInOutLbl.setText(record.lastAction(user.getEmployeeID()));
        if(record.isClockedIn()) {
            clockInOutButton.setText("Clock Out");
        }
    }

    @FXML
    protected void onLogOutButton() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure you want to log out?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES){
            System.exit(0);
        }
    }

    @FXML
    protected void onWaiterButton() throws IOException {
        if(!record.isClockedIn()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"You did not clocked in. Do you want to clock in first?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES){
                alert.close();
                return;
            }
        }
        String[] waiterUser = null;
        try {
            String dataLine = "";
            File myFile = new File("Employee.csv");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                if (line[0].equalsIgnoreCase(String.valueOf(user.getEmployeeID()))) {
                    waiterUser = line;
                    break;
                }
            }
            scan.close();
        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
        if(waiterUser != null) {
            session.setMode("waiter");
            AnchorPane pane = FXMLLoader.load(getClass().getResource("Table-layout.fxml"));
            loginAs.getChildren().setAll(pane);
        }

    }

    @FXML
    protected void onClockInBtn() {
        if (!record.isClockedIn()) {
            clockInOutButton.setText("Clock Out");
            record.clockIn(user.getEmployeeID());
            clockInOutLbl.setText("Last action: Clock In at " + formatter.format(record.getClockInTime()));
        } else {
            clockInOutButton.setText("Clock In");
            record.clockOut(user.getEmployeeID());
            clockInOutLbl.setText("Last action: Clock Out at " + formatter.format(record.getClockOutTime()));
        }
    }
    @FXML
    protected void onManagerBtn() throws IOException {
        if(!record.isClockedIn()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"You did not clocked in. Do you want to clock in first?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES){
                alert.close();
                return;
            }
        }
        session.setMode("manager");
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Table-layout.fxml"));
        loginAs.getChildren().setAll(pane);
    }
}
