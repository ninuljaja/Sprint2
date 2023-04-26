package com.sprint2.gui;

import javafx.beans.property.ReadOnlyStringWrapper;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeProfileEditorController {

    @FXML
    private TableView<String[]> employeeTable;
    @FXML
    private TableColumn<String[], String> employee, role;

    private ArrayList<Employee> employees = new ArrayList<>();

    ObservableList<String[]> data = FXCollections.observableArrayList();



    public void initialize() {
        Session session = Session.getInstance();
        Employee user = session.getUser();
        updateEmployeeList();

        employee.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));


        role.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        employeeTable.setItems(data);

    }

    public void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
        Parent root = loader.load();
        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
    }

    public void updateEmployeeList(){
        try {
            String dataLine = "";
            File myFile = new File("Employee.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();

                // Split the string by comma
                String[] line = dataLine.split(",");
                Employee emp = new Employee(line);
                employees.add(emp);
                String[] parts = {(emp.getFirstName() + " " +emp.getLastName()), emp.getPosition()};
                data.add(parts);
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
