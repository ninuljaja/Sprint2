package com.sprint2.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application {
    private static Stage stage;
    private static EmployeeDatabase employeeDatabase = new EmployeeDatabase();

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        employeeDatabase.loadFromFile();
    }

    public static void main(String[] args) {

        launch();
    }

    public static Stage getStage()
    {
        return stage;
    }

    public static EmployeeDatabase getEmployeeDatabase()
    {
        return employeeDatabase;
    }
}