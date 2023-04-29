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
    protected void onEmployeeProfileButton() {
        lm.goToNextStage("EmployeeProfile-view.fxml", employeeProfileButton);
    }

    @FXML
    protected void onActivityButton() {
        System.out.println("Daily activity");
    }

    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        lm.goBack("LoginAs.fxml", actionEvent);
    }
}
