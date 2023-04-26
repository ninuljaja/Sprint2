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
import java.util.Scanner;

public class MenuViewController {

    @FXML
    private Label itemNameLbl;
    @FXML
    private Button addToOrderBtn;

    @FXML
    private Pane selectionPane;



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
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));

        }else {
            System.out.println("Item not Found");
        }
    }

    public void onA2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A2");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onA3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A3");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onA4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("A4");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onW1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W1");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onW2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W2");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onW3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W3");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onW4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("W4");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onSw1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw1");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onSw2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw2");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onSw3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw3");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onSw4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("Sw4");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onS1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S1");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onS2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S2");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onS3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S3");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onS4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("S4");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onE1Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E1");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onE2Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E2");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onE3Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E3");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
    }

    public void onE4Btn(ActionEvent actionEvent) {
        String[] itemArray = findItem("E4");
        if(itemArray != null){
            Item item = new Item(itemArray);
            selectionPane.setVisible(true);
            itemNameLbl.setText(item.getItemName());
            addToOrderBtn.setText(String.format("Add to Order ($%.2f)", item.getPrice()));
        }
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
    }
}



