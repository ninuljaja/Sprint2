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

import java.io.IOException;
import java.util.List;

public class EmployeeProfileEditorController {

    @FXML
    private TableView<String[]> employeeTable;
    @FXML
    private TableColumn<String[], String> employee, role, id;

    private List<Employee> employees;

    ObservableList<String[]> data = FXCollections.observableArrayList();

    public void initialize() {
        Session session = Session.getInstance();
        Employee user = session.getUser();
        employees = session.employeeList();
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
        for (Employee employee : GUIApplication.getEmployeeDatabase().getEmployees())
        {
            employees.add(employee);
            String[] parts = {String.valueOf(employee.employeeID), employee.getFirstName() + " " + employee.getLastName(), employee.getPosition()};
            data.add(parts);
        }
    }

    @FXML
    protected void onEditProfile() throws IOException
    {
        int row = getSelectedRowNdx();
        if (row == -1) return;
        Employee selectedEmployee = employees.get(row);
        LoaderManager.LoadScreen("ProfileEditor.fxml");
        ProfileEditorController controller = (ProfileEditorController) LoaderManager.getController();
        controller.LoadEmployee(selectedEmployee);
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
