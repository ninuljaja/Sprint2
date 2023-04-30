package com.sprint2.gui;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeProfileEditorController {

    @FXML
    private TableView<String[]> employeeTable;
    @FXML
    private TableColumn<String[], String> employee, role, id;

    private ArrayList<Employee> employees;

    ObservableList<String[]> data = FXCollections.observableArrayList();
    Session session;
    Employee user;
    LoaderManager lm = new LoaderManager();



    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
        employees = session.employeeList();
        updateEmployeeList();

        id.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        employee.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        role.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[2]));

        employeeTable.setItems(data);
    }
    @FXML
    protected void onGoBackBtn(ActionEvent actionEvent) throws IOException {

        lm.goBack("ManagerScreenSelection.fxml", actionEvent);
    }
    @FXML
    protected void updateEmployeeList(){
        if(employees != null && !employees.isEmpty()) {
            for (Employee emp : employees) {
                String[] parts = {String.valueOf(emp.employeeID), (emp.getFirstName() + " " + emp.getLastName()), emp.getPosition()};
                data.add(parts);
            }
        }
    }
}
