package com.sprint2.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class LoaderManager {

    private static Object activeController = null;



    public static Node LoadNode(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(LoaderManager.class.getResource(fxmlFileName));
        return loader.load();
    }

    public static Parent LoadScreen(String fxmlFileName) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(LoaderManager.class.getResource(fxmlFileName));
        Parent root = loader.load();
        activeController = loader.getController();
        GUIApplication.getStage().setScene(new Scene(root));
        return root;
    }

    public static Object getController()
    {
        return activeController;
    }
}
