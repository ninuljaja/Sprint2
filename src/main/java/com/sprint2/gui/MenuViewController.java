package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuViewController {

    @FXML
    private Label itemNameLbl;
    @FXML
    private Button addToOrderBtn;

    @FXML
    private Pane selectionPane;
    private Item item = null;
    private Session session = null;
    private Employee user = null;

    private Waiter waiter = null;
    private Table table = null;
    List<OrderItem> orderItems = new ArrayList<>();

    public void initialize() {
        session = Session.getInstance();
        user = session.getUser();
        table = session.getSelectedTable();
        if(session.getMode().equalsIgnoreCase("waiter")){
            waiter = new Waiter(session.getUser());
        }
    }

    public void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Table-layout.fxml"));
        Parent root = loader.load();
        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
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
            System.out.println("Error: " + ioex.getMessage());
        }
        return null;
    }

    public void onAddToOrder(ActionEvent actionEvent) {
     /*   if(item != null && table != null){
            orderItems.add(waiter.addOrderItem(item, ));
        }*/
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
}



