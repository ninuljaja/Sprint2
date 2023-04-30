package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class ManagerScreenSelectionController {

    @FXML
    private Button employeeProfileButton, activityButton, menuModificationButton, floorPlanButton, scheduleButton, statisticsButton;

    private LoaderManager lm = new LoaderManager();

    public ManagerScreenSelectionController(){
    }

    public void initialize() {
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
}
