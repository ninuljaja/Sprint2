package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoaderManager {
    public LoaderManager(){

        }
    public void goToNextStage(String filename, Button login){
        try {
            Stage stage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
            Parent root = loader.load();
            stage = (Stage) login.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToNextPane(AnchorPane currentPane, String filename) throws IOException {
        AnchorPane nextPane = FXMLLoader.load(getClass().getResource(filename));
        currentPane.getChildren().setAll(nextPane);
    }

    public void goBack(String filename, ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(filename));
        Parent root = loader.load();
        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
    }

    public static Node LoadNode(String fxmlFileName, String nodeId) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoaderManager.class.getResource(fxmlFileName));
        return loader.load();
    }
}
