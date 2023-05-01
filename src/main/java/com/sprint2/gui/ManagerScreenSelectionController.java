package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ManagerScreenSelectionController {


    private Session session = null;

    public ManagerScreenSelectionController(){
    }

    public void initialize() {
        session = Session.getInstance();
    }

    @FXML
    protected void onEmployeeProfileButton() throws IOException {
        LoaderManager.LoadScreen("EmployeeProfile-view.fxml");
    }

    @FXML
    protected void onActivityButton() throws IOException {
        LoaderManager.LoadScreen("ManagerActivityScreen.fxml");
    }

    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        LoaderManager.LoadScreen("LoginAs.fxml");
    }

    public void onViewActiveOrders(ActionEvent actionEvent) throws IOException {

        LoaderManager.LoadScreen("Table-layout.fxml");
    }
}
