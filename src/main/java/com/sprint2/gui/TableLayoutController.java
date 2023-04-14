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

import java.io.IOException;

public class TableLayoutController {
    public Button tableB1Btn;
    @FXML
    private Button placeOrderBtn;
    @FXML
    private Button tableA1Btn, tableA2Btn,tableA3Btn, tableA42Btn, tableA5Btn, tableA6Btn;
@FXML
private AnchorPane pane;


    @FXML
    private Label tableNumberLabel;


    public TableLayoutController() throws IOException {

    }



    @FXML
    protected void onTableA1(){
        tableNumberLabel.setText("Table A1");
        placeOrderBtn.setDisable(false);


    }

    @FXML
    protected void onTableA2(){
        tableNumberLabel.setText("Table A2");
        placeOrderBtn.setDisable(false);



    }

    @FXML
    protected void onTableA3(){
        tableNumberLabel.setText("Table A3");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableA4(){
        tableNumberLabel.setText("Table A4");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableA5(){
        tableNumberLabel.setText("Table A5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableA6(){
        tableNumberLabel.setText("Table A6");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB1(){
        tableNumberLabel.setText("Table B1");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB2(){
        tableNumberLabel.setText("Table B2");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB3(){
        tableNumberLabel.setText("Table B3");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB4(){
        tableNumberLabel.setText("Table B4");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB5(){
        tableNumberLabel.setText("Table B5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableB6(){
        tableNumberLabel.setText("Table B6");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableC5(){
        tableNumberLabel.setText("Table C5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableC6(){
        tableNumberLabel.setText("Table C6");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableD5(){
        tableNumberLabel.setText("Table D5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableD6(){
        tableNumberLabel.setText("Table D6");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE1(){
        tableNumberLabel.setText("Table E1");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE2(){
        tableNumberLabel.setText("Table E2");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE3(){
        tableNumberLabel.setText("Table E3");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE4(){
        tableNumberLabel.setText("Table E4");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE5(){
        tableNumberLabel.setText("Table E5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableE6(){
        tableNumberLabel.setText("Table E6");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF1(){
        tableNumberLabel.setText("Table F1");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF2(){
        tableNumberLabel.setText("Table F2");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF3(){
        tableNumberLabel.setText("Table F3");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF4(){
        tableNumberLabel.setText("Table F4");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF5(){
        tableNumberLabel.setText("Table F5");
        placeOrderBtn.setDisable(false);

    }
    @FXML
    protected void onTableF6(){
        tableNumberLabel.setText("Table F6");
        placeOrderBtn.setDisable(false);

    }

    @FXML

    public void onPlaceOrderBtn(ActionEvent actionEvent) throws IOException {

    }


    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginAs.fxml"));
        Parent root = loader.load();

        // Get the current node and its parent scene
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        scene.setRoot(root);
    }
}
