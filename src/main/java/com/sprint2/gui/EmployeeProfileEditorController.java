package com.sprint2.gui;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class EmployeeProfileEditorController {

    @FXML
    private TableView employeeTable;
    @FXML
    private TableColumn employee, role;




    public void initialize() {
        Session session = Session.getInstance();
        Employee user = session.getUser();

        ObservableList<Employee> data = FXCollections.observableArrayList();

    }

    public void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
        Parent root = loader.load();
        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
    }
}
