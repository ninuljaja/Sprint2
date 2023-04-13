package com.sprint2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class TableLayoutController {
    @FXML
    private Button placeOrderBtn;
    @FXML
    private Button tableA1Btn, tableA2Btn,tableA3Btn, tableA42Btn, tableA5Btn, tableA6Btn;

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

    }

    @FXML
    protected void onTableA3(){
        tableNumberLabel.setText("Table A3");

    }
    @FXML
    protected void onTableA4(){
        tableNumberLabel.setText("Table A4");

    }
    @FXML
    protected void onTableA5(){
        tableNumberLabel.setText("Table A5");

    }
    @FXML
    protected void onTableA6(){
        tableNumberLabel.setText("Table A6");

    }
    @FXML
    protected void onTableB1(){
        tableNumberLabel.setText("Table B1");

    }
    @FXML
    protected void onTableB2(){
        tableNumberLabel.setText("Table B2");

    }
    @FXML
    protected void onTableB3(){
        tableNumberLabel.setText("Table B3");

    }
    @FXML
    protected void onTableB4(){
        tableNumberLabel.setText("Table B4");

    }
    @FXML
    protected void onTableB5(){
        tableNumberLabel.setText("Table B5");

    }
    @FXML
    protected void onTableB6(){
        tableNumberLabel.setText("Table B6");

    }
    @FXML
    protected void onTableC5(){
        tableNumberLabel.setText("Table C5");

    }
    @FXML
    protected void onTableC6(){
        tableNumberLabel.setText("Table C6");

    }
    @FXML
    protected void onTableD5(){
        tableNumberLabel.setText("Table D5");

    }
    @FXML
    protected void onTableD6(){
        tableNumberLabel.setText("Table D6");

    }
    @FXML
    protected void onTableE1(){
        tableNumberLabel.setText("Table E1");

    }
    @FXML
    protected void onTableE2(){
        tableNumberLabel.setText("Table E2");

    }
    @FXML
    protected void onTableE3(){
        tableNumberLabel.setText("Table E3");

    }
    @FXML
    protected void onTableE4(){
        tableNumberLabel.setText("Table E4");

    }
    @FXML
    protected void onTableE5(){
        tableNumberLabel.setText("Table E5");

    }
    @FXML
    protected void onTableE6(){
        tableNumberLabel.setText("Table E6");

    }
    @FXML
    protected void onTableF1(){
        tableNumberLabel.setText("Table F1");

    }
    @FXML
    protected void onTableF2(){
        tableNumberLabel.setText("Table F2");

    }
    @FXML
    protected void onTableF3(){
        tableNumberLabel.setText("Table F3");

    }
    @FXML
    protected void onTableF4(){
        tableNumberLabel.setText("Table F4");

    }
    @FXML
    protected void onTableF5(){
        tableNumberLabel.setText("Table F5");

    }
    @FXML
    protected void onTableF6(){
        tableNumberLabel.setText("Table F6");

    }
    @FXML
    protected void onGoBack(){
        System.exit(0);

    }


    public void onPlaceOrderBtn(ActionEvent actionEvent) {
    }
}
