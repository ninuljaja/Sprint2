package com.sprint2.gui;

import javafx.scene.control.TableCell;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class WrappingTextCell extends TableCell<String[], String> {
    private final Text text;

    public WrappingTextCell() {
        text = new Text();
        text.setTextAlignment(TextAlignment.LEFT);
        text.wrappingWidthProperty().bind(widthProperty().subtract(10));
        setGraphic(text);
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            text.setText("");
        } else {
            text.setText(item);
            setGraphic(text);
        }
    }
}