package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Date;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatterBuilder;

public class ActivityScreenController {
    
    @FXML
    Parent activityLogTemplate;
    @FXML
    VBox logContainer;

    private LoaderManager lm = new LoaderManager();

    public void initialize()
    {
        CreateLog("Test title", "Test text", new Date());
        CreateLog("Test title 2", "Test text 2", new Date());
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
            node = LoaderManager.LoadNode("ActivityLogTemplate.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Label titleLabel = (Label) node.lookup("#title");
        titleLabel.setText(title);
        Label textLabel = (Label) node.lookup("#text");
        textLabel.setText(FormatLogDate(date) + " " + text);
        //System.out.println(titleLabel);

        AddLog(node);
    }

    private String FormatLogDate(Date date) {
        return "";
    }
}
