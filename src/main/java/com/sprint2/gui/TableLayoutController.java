package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TableLayoutController {
    @FXML
    private Button placeOrderBtn, fillTableBtn, viewOrdersBtn, markAsDirtyBtn;
    @FXML
    private Button A1, A2,A3, A4, A5, A6, B1, B2, B3, B4, B5, B6, C5, C6, D5, D6, E1, E2, E3, E4, E5, E6, F1, F2, F3, F4, F5, F6;
    private ArrayList<Button> tableButtons = new ArrayList<>();

    @FXML
    private AnchorPane tableLayout;
    @FXML
    private Label tableNumberLabel;
    private Table table;
    private String[] tableData = null;

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
        updateAllTables();
        if(session.getMode().equalsIgnoreCase("waiter")){
            waiter = new Waiter(session.getUser());
        }
        updateButtonAvailability();
        updateButtonStatus();
    }

    private void updateButtonStatus() {
        for (Button tableButton : tableButtons) {
            String existingStyle = tableButton.getStyle();
            for (Table table : allTables){
                Button button = (Button) tableButton.lookup("#" + table.getTableID());
                if (button != null) {
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

    private void updateButtonAvailability() {

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
                // }
        } else if (session.getMode().equalsIgnoreCase("manager") || session.getMode().equalsIgnoreCase("host")) {
            for (Button tableButton : tableButtons) {
                tableButton.setDisable(false);
            }
        }
    }

    @FXML
    protected void onTableA1(){

        tableData = getTable("A1");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }

    @FXML
    protected void onTableA2(){
        tableData = getTable("A2");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }

    @FXML
    protected void onTableA3() {
        tableData = getTable("A3");
        if (tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if (session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if (table.getStatus().equalsIgnoreCase("Ready")) {
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if (session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableA4(){
        tableData = getTable("A4");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableA5(){
        tableData = getTable("A5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableA6(){
        tableData = getTable("A6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB1(){
        tableData = getTable("B1");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB2(){
        tableData = getTable("B2");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB3(){
        tableData = getTable("B3");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB4(){
        tableData = getTable("B4");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB5(){
        tableData = getTable("B5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableB6(){
        tableData = getTable("B6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableC5(){
        tableData = getTable("C5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableC6(){
        tableData = getTable("C6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableD5(){
        tableData = getTable("D5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableD6(){
        tableData = getTable("D6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE1(){
        tableData = getTable("E1");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE2(){
        tableData = getTable("E2");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE3(){
        tableData = getTable("E3");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE4(){
        tableData = getTable("E4");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE5(){
        tableData = getTable("E5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableE6(){
        tableData = getTable("E6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF1(){
        tableData = getTable("F1");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF2(){
        tableData = getTable("F2");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF3(){
        tableData = getTable("F3");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF4(){
        tableData = getTable("F4");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF5(){
        tableData = getTable("F5");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }
    @FXML
    protected void onTableF6(){
        tableData = getTable("F6");
        if(tableData != null) {
            table = new Table(tableData);
            tableNumberLabel.setText("Table " + table.getTableID());
            if(session.getMode().equalsIgnoreCase("waiter")) {
                if (table.getStatus().equalsIgnoreCase("Occupied")) {
                    placeOrderBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                    viewOrdersBtn.setDisable(false);
                } else if(table.getStatus().equalsIgnoreCase("Ready")){
                    fillTableBtn.setDisable(false);
                    markAsDirtyBtn.setDisable(false);
                }
            } else if(session.getMode().equalsIgnoreCase("manager")) {
                viewOrdersBtn.setDisable(false);
                markAsDirtyBtn.setDisable(false);
            }
        }
    }

    @FXML

    public void onPlaceOrderBtn(ActionEvent actionEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("Menu-view.fxml"));
        tableLayout.getChildren().setAll(pane);

    }
    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
        Parent root = loader.load();

        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
    }
    public String[] getTable(String tableID){
        try {
            String dataLine = "";
            File myFile = new File("Tables.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                allTables.add(new Table(line));
                if (line[0].equalsIgnoreCase(tableID)) {
                    return line;
                }
            }
            scan.close();

        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
        return null;
    }
    public void updateAllTables(){
        allTables.removeAll(allTables);
        try {
            String dataLine = "";
            File myFile = new File("Tables.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                allTables.add(new Table(line));
            }
            scan.close();

        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
    }
}
