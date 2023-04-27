package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MenuViewController {

    @FXML
    private Label itemNameLbl;
    @FXML
    private Button addToOrderBtn;
    @FXML
    private RadioButton chipotleSauce, ranchSauce, buffaloSauce, blueCheeseSauce, bbqSauce, carolinaGoldSauce, jimBeamSauce, noneSauce;
    @FXML
    private RadioButton chickenProtein, porkProtein, hamProtein , noneProtein;
    @FXML
    private TextArea comments;
    @FXML
    private Pane selectionPane;

    private ArrayList<RadioButton> sauces = new ArrayList<>();
    private ArrayList<RadioButton> protein = new ArrayList<>();
    private Item item = null;
    private Session session = null;
    private Employee user = null;

    private Waiter waiter = null;
    private Table table = null;
    ArrayList<OrderItem> orderItems = new ArrayList<>();

    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
        table = session.getSelectedTable();
        if(session.getMode().equalsIgnoreCase("waiter")){
            waiter = new Waiter(session.getUser());
        }
        selectionPane.setVisible(false);
        sauces.addAll(Arrays.asList(chipotleSauce,ranchSauce,buffaloSauce,blueCheeseSauce,bbqSauce,carolinaGoldSauce,jimBeamSauce,noneSauce));
        protein.addAll(Arrays.asList(chickenProtein,porkProtein,hamProtein, noneProtein));

    }


    public void onA1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A1");
        choseItem(itemArray);
    }

    public void onA2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A2");
        choseItem(itemArray);
    }

    public void onA3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A3");
        choseItem(itemArray);
    }

    public void onA4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A4");
        choseItem(itemArray);
    }

    public void onW1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W1");
        choseItem(itemArray);
    }

    public void onW2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W2");
        choseItem(itemArray);
    }

    public void onW3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W3");
        choseItem(itemArray);
    }

    public void onW4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W4");
        choseItem(itemArray);
    }

    public void onSw1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw1");
        choseItem(itemArray);
    }

    public void onSw2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw2");
        choseItem(itemArray);
    }

    public void onSw3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw3");
        choseItem(itemArray);
    }

    public void onSw4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw4");
        choseItem(itemArray);
    }

    public void onS1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S1");
        choseItem(itemArray);
    }

    public void onS2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S2");
        choseItem(itemArray);
    }

    public void onS3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S3");
        choseItem(itemArray);
    }

    public void onS4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S4");
        choseItem(itemArray);
    }

    public void onE1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E1");
        choseItem(itemArray);
    }

    public void onE2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E2");
        choseItem(itemArray);
    }

    public void onE3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E3");
        choseItem(itemArray);
    }

    public void onE4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E4");
        choseItem(itemArray);
    }

    public String[] findItem(String itemCode) {
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

    public void onAddToOrder(ActionEvent actionEvent) {
        String addons = " ";
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Add an item to the order?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES){
            if(item != null && table != null && !sauces.isEmpty() && !protein.isEmpty()){
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
                addToOrderBtn.setText("Add to order");
                addToOrderBtn.setDisable(true);
            }
        }

    }
    public void choseItem(String[] itemArray){
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
    public void onPlaceOrderBtn() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Place an order?", ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("");
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            if (orderItems != null && table != null) {
                waiter.createOrder(table, orderItems);
                selectionPane.setVisible(false);
                addToOrderBtn.setText("Add to order");
                addToOrderBtn.setDisable(true);
                orderItems.removeAll(orderItems);
            } else {
                System.out.println("Chose an item");
            }
        }
    }
    public void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        LoaderManager lm = new LoaderManager();
        lm.goBack("Table-layout.fxml", actionEvent);
    }

}



