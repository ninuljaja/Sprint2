package com.sprint2.gui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TableLayoutController {
    @FXML
    private Button placeOrderBtn, fillTableBtn, viewOrdersBtn, markAsDirtyBtn;
    private ArrayList<Button> buttons = new ArrayList<>();
    @FXML
    private Button goBackBtn;
    @FXML
    private Button A1, A2,A3, A4, A5, A6, B1, B2, B3, B4, B5, B6, C5, C6, D5, D6, E1, E2, E3, E4, E5, E6, F1, F2, F3, F4, F5, F6;
    private ArrayList<Button> tableButtons = new ArrayList<>();
    private LoaderManager lm = new LoaderManager();

    @FXML
    private AnchorPane tableLayout;
    @FXML
    private Label tableNumberLabel;
    private Table table;
    private ArrayList<Table> tables = null;
    private ArrayList<Table> allTables = new ArrayList<>();
    private Employee user;
    private Session session = null;
    private Waiter waiter = null;



    public TableLayoutController() throws IOException {

    }
    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
        tableButtons.addAll(Arrays.asList(A1,A2,A3,A4,A5,A6,B1,B2,B3,B4,B5,B6,C5,C6,D5,D6,E1,E2,E3,E4,E5,E6,F1,F2,F3,F4,F5,F6));
        buttons.addAll(Arrays.asList(placeOrderBtn, fillTableBtn, viewOrdersBtn, markAsDirtyBtn));
        allTables = session.tableList();
        Platform.runLater(() -> goBackBtn.requestFocus());
        if(session.getMode().equalsIgnoreCase("waiter")){
            waiter = new Waiter(session.getUser());
        }
        updateTableButtonAvailability();
        updateTableButtonStatus();

    }

    private void updateTableButtonStatus() {
        for (Button tableButton : tableButtons) {
            String existingStyle = tableButton.getStyle();
            for (Table table : allTables){
                Button button = (Button) tableButton.lookup("#" + table.getTableID());
                if (button != null && !button.isDisable()) {
                    if(table.getStatus().equalsIgnoreCase("READY")){
                        tableButton.setStyle(existingStyle + "-fx-background-color: #83df5bff;");
                    } else if (table.getStatus().equalsIgnoreCase("OCCUPIED")){
                        tableButton.setStyle(existingStyle + "-fx-background-color: #f0f00bff;");
                    } else if(table.getStatus().equalsIgnoreCase("DIRTY")){
                        tableButton.setStyle(existingStyle + "-fx-background-color: #e41111ff;");
                    }
                }
            }
        }
    }

    private void updateTableButtonAvailability() {

        if (session.getMode().equalsIgnoreCase("waiter")) {
            tables = waiter.getAssignedTable();
            if (!tables.isEmpty()) {
                for (Table table : tables) {
                    for (Button tableButton : tableButtons) {
                        Button button = (Button) tableButton.lookup("#" + table.getTableID());
                        if (button != null) {
                            tableButton.setDisable(false);
                        }
                    }
                }
            }
        } else if (session.getMode().equalsIgnoreCase("manager") || session.getMode().equalsIgnoreCase("host")) {
            for (Button tableButton : tableButtons) {
                tableButton.setDisable(false);
            }
        }
    }

    @FXML
    protected void onTableA1(){
        table = session.getTable("A1");
        setButtonStatus(table);
    }

    @FXML
    protected void onTableA2(){
        table = session.getTable("A2");
        setButtonStatus(table);
    }

    @FXML
    protected void onTableA3() {
        table = session.getTable("A3");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableA4(){
        table = session.getTable("A4");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableA5(){
        table = session.getTable("A5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableA6(){
        table = session.getTable("A6");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB1(){
        table = session.getTable("B1");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB2(){
        table = session.getTable("B2");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB3(){
        table = session.getTable("B3");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB4(){
        table = session.getTable("B4");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB5(){
        table = session.getTable("B5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableB6(){
        table = session.getTable("B6");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableC5(){
        table = session.getTable("C5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableC6(){
        table = session.getTable("C6");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableD5(){
        table = session.getTable("D5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableD6(){
        table = session.getTable("D6");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE1(){
        table = session.getTable("E1");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE2(){
        table = session.getTable("E2");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE3(){
        table = session.getTable("E3");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE4(){
        table = session.getTable("E4");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE5(){
        table = session.getTable("E5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableE6(){
        table = session.getTable("E6");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF1(){
        table = session.getTable("F1");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF2(){
        table = session.getTable("F2");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF3(){
        table = session.getTable("F3");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF4(){
        table = session.getTable("F4");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF5(){
        table = session.getTable("F5");
        setButtonStatus(table);
    }
    @FXML
    protected void onTableF6(){
        table = session.getTable("F6");
        setButtonStatus(table);
    }

    @FXML
    protected void onPlaceOrderBtn(ActionEvent actionEvent) throws IOException {
        session.setSelectedTable(table);
        lm.goToNextPane(tableLayout,"Menu-view.fxml");
    }

    @FXML
    protected void onViewOrdersBtn() throws IOException {
        session.loadActiveOrders();
        ArrayList<Order> orders = session.getData(table.getTableID());
        if(!orders.isEmpty()) {
            session.setSelectedTable(table);
            lm.goToNextPane(tableLayout, "Orders-View.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING,"No active orders", ButtonType.OK);
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }
    @FXML
    protected void onMarkAsDirtyBtn(){

    }
    @FXML
    protected void goBack(ActionEvent actionEvent) throws IOException {
        lm.goBack("LoginAs.fxml", actionEvent);
    }

    protected void setButtonStatus(Table data){
        for (Button button : buttons) {
            button.setDisable(true);
        }
        if(data != null) {
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
}
