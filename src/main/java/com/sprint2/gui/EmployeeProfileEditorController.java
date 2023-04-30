package com.sprint2.gui;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeProfileEditorController {

    @FXML
    private TableView<String[]> employeeTable;
    @FXML
    private TableColumn<String[], String> employee, role, id;

    private List<Employee> employees;

    ObservableList<String[]> data = FXCollections.observableArrayList();

    private LoaderManager lm = new LoaderManager();


    public void initialize() {
        Session session = Session.getInstance();
        Employee user = session.getUser();
        employees = new ArrayList<>();
        updateEmployeeList();

        id.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        employee.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        role.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[2]));

        employeeTable.setItems(data);
    }
    @FXML
    protected void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        LoaderManager.LoadScreen("ManagerScreenSelection.fxml");
    }
    @FXML
    protected void updateEmployeeList(){
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
                String[] parts = {String.valueOf(emp.employeeID),(emp.getFirstName() + " " +emp.getLastName()), emp.getPosition()};
                data.add(parts);
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    @FXML
    protected void onEditProfile() throws IOException
    {
        int row = getSelectedRowNdx();
        if (row == -1) return;
        LoaderManager.LoadScreen("ProfileEditor.fxml");
        System.out.println("post-load test");
        // TODO: load in existing profile data
    }

    @FXML
    protected void onDeleteProfile()
    {
        int row = getSelectedRowNdx();
        if (row == -1) return;
        Employee selectedEmployee = employees.get(row);
        int employeeId = selectedEmployee.employeeID;
        if (employeeId == Session.getInstance().getUser().employeeID) 
        {
            showCannotDeleteCurrentProfileAlert();
            return;
        }

        String employeeName = selectedEmployee.getFirstName() + " " + employees.get(row).getLastName();
        
        // TODO: current account cannot be deleted

        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to delete the profile for employee " + employeeName + " (id " + employeeId + ")? This cannot be undone.", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Confirm Deletion of Employee Profile");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES){
            alert.close();
            deleteProfile(row);
            return;
        }
    }

    @FXML
    protected void onCreateProfile() throws IOException
    {
        LoaderManager.LoadScreen("ProfileEditor.fxml");
    }

    private int getSelectedRowNdx()
    {
        return employeeTable.getSelectionModel().getSelectedIndex();
    }

    private void deleteProfile(int ndx)
    {
        System.out.println("Delete profile " + ndx);
    }

    private void showCannotDeleteCurrentProfileAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "You cannot delete the profile you are currently logged in as.");
        alert.setHeaderText("Cannot Delete Active Profile");
        alert.showAndWait();
    }
}
