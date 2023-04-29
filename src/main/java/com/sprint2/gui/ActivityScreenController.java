package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Date;

public class ActivityScreenController {
    
    @FXML
    Parent activityLogTemplate;
    @FXML
    VBox logContainer;

    private LoaderManager lm = new LoaderManager();

    public void initialize()
    {
        System.out.println("initialized");
        CreateLog("", "", new Date());
        CreateLog("", "", new Date());
    }

    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        lm.goBack("ManagerScreenSelection.fxml", actionEvent);
    }

    private void AddLog(Node newLog)
    {
        logContainer.getChildren().add(newLog);
        
    }

    private void CreateLog(String title, String text, Date date)
    {
        Node node;
        try {
            node = LoaderManager.LoadNode("ActivityLogTemplate.fxml", "activityLogTemplate");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        AddLog(node);
    }

    private String FormatLogDate(Date date) {
        return "";
    }
}
