package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ManagerScreenSelectionController {

    @FXML
    private Button employeeProfileButton, activityButton, menuModificationButton, floorPlanButton, viewActiveOrders, statisticsButton;
    @FXML
    AnchorPane managerScreenSelection;

    private LoaderManager lm = new LoaderManager();
    private Session session = null;
    private Employee user = null;

    public ManagerScreenSelectionController(){
    }

    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
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
        lm.goToNextPane(managerScreenSelection, "Table-layout.fxml");
    }
}
