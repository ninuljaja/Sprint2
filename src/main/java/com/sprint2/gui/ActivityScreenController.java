package com.sprint2.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ActivityScreenController {
    private LoaderManager lm = new LoaderManager();

    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        lm.goBack("ManagerScreenSelection.fxml", actionEvent);
    }

    // TODO: generate log java fx objects automatically
}
