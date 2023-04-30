package com.sprint2.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuViewController {

    @FXML
    private Label itemNameLbl, orderLbl;
    @FXML
    private Button addToOrderBtn, deleteItemBtn, goBackBtn, viewOrderBtn;
    @FXML
    private RadioButton chipotleSauce, ranchSauce, buffaloSauce, blueCheeseSauce, bbqSauce, carolinaGoldSauce, jimBeamSauce, noneSauce;
    @FXML
    private RadioButton chickenProtein, porkProtein, hamProtein , noneProtein;
    @FXML
    private TextArea comments;
    @FXML
    private Pane selectionPane, viewOrderPane;
    @FXML
    private TableView<String[]> orderListTbl;
    @FXML
    private ScrollPane menuPane;
    @FXML
    private GridPane addOnsPane;
    @FXML
    private Group menuGroup;
    @FXML
    private TableColumn<String[], String> itemColumn, addonsColumn, commentsColumn, priceColumn;
    private ArrayList<TableColumn<String[], String>> tableColumns;
    private ArrayList<RadioButton> sauces;
    private ArrayList<RadioButton> protein;
    private Item item = null;
    private Session session = null;
    private Employee user = null;

    private Waiter waiter = null;
    private Table table = null;
    ArrayList<OrderItem> orderItems = new ArrayList<>();
    ObservableList<String[]> orderList;


    public void initialize() {
        tableColumns = new ArrayList<>();
        sauces = new ArrayList<>();
        session = Session.getInstance();
        protein = new ArrayList<>();
        user = session.getUser();
        table = session.getSelectedTable();
        if(session.getMode().equalsIgnoreCase("waiter")){
            waiter = new Waiter(session.getUser());
        }
        goBackBtn.setText("Go Back");
        selectionPane.setVisible(false);
        orderList = FXCollections.observableArrayList();
        sauces.addAll(Arrays.asList(chipotleSauce,ranchSauce,buffaloSauce,blueCheeseSauce,bbqSauce,carolinaGoldSauce,jimBeamSauce,noneSauce));
        protein.addAll(Arrays.asList(chickenProtein,porkProtein,hamProtein, noneProtein));
        tableColumns.addAll(Arrays.asList(itemColumn, addonsColumn, commentsColumn, priceColumn));
        menuPane.setVisible(true);
        orderLbl.setVisible(false);
        menuGroup.setVisible(true);
        addOnsPane.setVisible(true);
        addToOrderBtn.setDisable(true);
        itemNameLbl.setText("");
        orderListTbl.setVisible(false);
        viewOrderPane.setVisible(false);
    }


    @FXML
    protected void onA1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A1");
        choseItem(itemArray);
    }
    @FXML
    protected void onA2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A2");
        choseItem(itemArray);
    }
    @FXML
    protected void onA3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A3");
        choseItem(itemArray);
    }
    @FXML
    protected void onA4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A4");
        choseItem(itemArray);
    }
    @FXML
    protected void onW1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W1");
        choseItem(itemArray);
    }
    @FXML
    protected void onW2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W2");
        choseItem(itemArray);
    }
    @FXML
    protected void onW3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W3");
        choseItem(itemArray);
    }
    @FXML
    protected void onW4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W4");
        choseItem(itemArray);
    }
    @FXML
    protected void onSw1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw1");
        choseItem(itemArray);
    }
    @FXML
    public void onSw2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw2");
        choseItem(itemArray);
    }
    @FXML
    protected void onSw3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw3");
        choseItem(itemArray);
    }
    @FXML
    protected void onSw4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw4");
        choseItem(itemArray);
    }
    @FXML
    protected void onS1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S1");
        choseItem(itemArray);
    }
    @FXML
    protected void onS2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S2");
        choseItem(itemArray);
    }
    @FXML
    protected void onS3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S3");
        choseItem(itemArray);
    }
    @FXML
    protected void onS4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S4");
        choseItem(itemArray);
    }
    @FXML
    protected void onE1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E1");
        choseItem(itemArray);
    }
    @FXML
    protected void onE2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E2");
        choseItem(itemArray);
    }
    @FXML
    protected void onE3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E3");
        choseItem(itemArray);
    }
    @FXML
    protected void onE4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E4");
        choseItem(itemArray);
    }

    protected String[] findItem(String itemCode) {
        try {
            String dataLine = "";
            File myFile = new File("Items.csv");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                if (line[0].equalsIgnoreCase(itemCode)) {
                    return line;
                }
            }
            scan.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return null;
    }

    protected void choseItem(String[] itemArray){
        if(itemArray != null){
            item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
            addToOrderBtn.setDisable(false);

        }else {
            System.out.println("Item not Found");
        }
    }

    @FXML
    protected void onAddToOrder(ActionEvent actionEvent) {

        if(item != null && table != null && !sauces.isEmpty() && !protein.isEmpty()){
            String addons = " ";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Add an item to the order?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES){
                for (RadioButton sauce : sauces){
                    if(sauce.isSelected()){
                        addons += "Add Sauce: " + sauce.getText() + ";";
                    }
                }
                for (RadioButton prot : protein){
                    if(prot.isSelected()){
                        addons += " Add Sauce: " + prot.getText();
                    }
                }
                orderItems.add(waiter.addOrderItem(item, 1, addons, comments.getText()));
                selectionPane.setVisible(false);
                itemNameLbl.setText("");
                addToOrderBtn.setText("Add to order");
                addToOrderBtn.setDisable(true);
                goBackBtn.setText("Cancel");
                noneProtein.setSelected(true);
                noneSauce.setSelected(true);
                viewOrderBtn.setDisable(false);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Choose an item", ButtonType.OK);
            alert.setHeaderText("");
            alert.showAndWait();
        }

    }
    @FXML
    private void onDeleteItemBtn(){
        int selectedIndex = orderListTbl.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            String[] selectedRow = orderListTbl.getItems().get(selectedIndex);
            if(!selectedRow[0].isEmpty()) {
                orderListTbl.getItems().removeAll();
                orderList.clear();
                orderItems.remove(selectedIndex);
                if (!orderItems.isEmpty()) {
                    onViewOrderBtn();
                } else {
                    viewOrderBtn.setDisable(true);
                }
            }
        }
    }
    @FXML
    private void onPlaceOrderBtn() {
        if(!orderItems.isEmpty()&& table != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Place an order?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                    waiter.createOrder(table, orderItems);
                    selectionPane.setVisible(false);
                    addToOrderBtn.setText("Add to order");
                    addToOrderBtn.setDisable(true);
                    orderItems.removeAll(orderItems);
                    orderList.clear();
                    initialize();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Add an Item", ButtonType.OK);
            alert.setHeaderText("");
            alert.showAndWait();
        }
    }

    @FXML
    private void onViewOrderBtn(){

        addOnsPane.setVisible(false);
        viewOrderPane.setVisible(true);
        orderListTbl.setVisible(true);
        menuPane.setVisible(false);
        orderLbl.setVisible(true);
        menuGroup.setDisable(false);
        session.viewOrder(tableColumns, orderList, orderItems, orderListTbl);
        deleteItemBtn.setDisable(false);


    }
    @FXML
    private void onAddItemBtn(){
        orderList.clear();
        addOnsPane.setVisible(true);
        viewOrderPane.setVisible(false);
        selectionPane.setVisible(false);
        orderListTbl.setVisible(false);
        menuPane.setVisible(true);
        orderLbl.setVisible(false);
        menuGroup.setVisible(true);
        addToOrderBtn.setDisable(true);
        addToOrderBtn.setText("Add to order");
        itemNameLbl.setText("");
    }
    @FXML
    private void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        if(goBackBtn.getText().equalsIgnoreCase("Cancel")){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Cancel the order?", ButtonType.YES, ButtonType.NO);
            alert.setHeaderText("");
            alert.showAndWait();

        }
        LoaderManager.LoadScreen("Table-layout.fxml");
    }






}
