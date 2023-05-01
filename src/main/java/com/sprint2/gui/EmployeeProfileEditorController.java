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
    Session session;
    Employee user;

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
        LoaderManager.LoadScreen("ManagerScreenSelection.fxml");
    }
    @FXML
    protected void updateEmployeeList(){
        data.clear();
        for (Employee employee : GUIApplication.getEmployeeDatabase().getEmployees())
        {
            employees.add(employee);
            String[] parts = {String.valueOf(employee.employeeID), employee.getFirstName() + " " + employee.getLastName(), employee.getPosition()};
            data.add(parts);
        }
    }

    private Employee getSelectedEmployee()
    {
        int selectedRow = employeeTable.getSelectionModel().getSelectedIndex();
        if (selectedRow == -1) return null;
        int employeeID = Integer.parseInt(id.getCellData(selectedRow));
        return GUIApplication.getEmployeeDatabase().getEmployeeById(employeeID);
    }

    @FXML
    protected void onEditProfile() throws IOException
    {
        Employee selectedEmployee = getSelectedEmployee();
        if(selectedEmployee != null) {
            LoaderManager.LoadScreen("ProfileEditor.fxml");
            ProfileEditorController controller = (ProfileEditorController) LoaderManager.getController();
            controller.LoadEmployee(selectedEmployee);
        }
    }

    @FXML
    protected void onDeleteProfile()
    {
        Employee selectedEmployee = getSelectedEmployee();
        if(selectedEmployee != null) {
            int employeeId = selectedEmployee.employeeID;
            if (employeeId == Session.getInstance().getUser().employeeID) {
                showCannotDeleteCurrentProfileAlert();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to delete the profile for " + selectedEmployee + "? This cannot be undone.", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("Confirm Deletion of Employee Profile");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                alert.close();
                deleteProfile(selectedEmployee);
                return;
            }
        }
    }

    @FXML
    protected void onCreateProfile() throws IOException
    {
        LoaderManager.LoadScreen("ProfileEditor.fxml");
        ProfileEditorController controller = (ProfileEditorController) LoaderManager.getController();
        controller.CreateEmployee();
    }

    private void deleteProfile(Employee employee)
    {
        System.out.println("Delete profile " + employee.getFirstName());
        GUIApplication.getEmployeeDatabase().deleteEmployee(employee);
        updateEmployeeList();
    }

    private void showCannotDeleteCurrentProfileAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, "You cannot delete the profile you are currently logged in as.");
        alert.setHeaderText("Cannot Delete Active Profile");
        alert.showAndWait();
    }
}
