package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityScreenController {
    
    @FXML
    Parent activityLogTemplate;
    @FXML
    VBox logContainer;

    private LoaderManager lm = new LoaderManager();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    public void initialize()
    {
        LoadLogs();
    }

    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        lm.goBack("ManagerScreenSelection.fxml", actionEvent);
    }

    private void AddLog(Node newLog)
    {
        logContainer.getChildren().add(newLog);
        newLog.toBack(); // moves the new log to the top of the VBox (assumed to be most recent)
    }

    private void CreateLog(String title, String text, LocalDateTime time)
    {
        Node node;
        try {
            node = LoaderManager.LoadNode("ActivityLogTemplate.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Label titleLabel = (Label) node.lookup("#title");
        titleLabel.setText(formatter.format(time) + " - " + title);
        Label textLabel = (Label) node.lookup("#text");
        textLabel.setText(text);

        AddLog(node);
    }

    private void LoadLogs()
    {
        for (ActivityLogging.Log log : ActivityLogging.getLogs())
        {
            CreateLog(log.title, log.text, log.time);
        }
    }
}
