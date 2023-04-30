package com.sprint2.gui;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;

public class OrdersViewController {
    @FXML
    private TableView<String[]> readyOrdersTbl, ordersInProcessTbl;
    @FXML
    private TableColumn<String[], String> inProcessOrdersNum, inProcessOrdersTotal, readyOrdersTotal,readyOrdersNum;
    private Session session = null;
    private Employee user = null;
    private Table table = null;
    private ObservableList<String[]> readyOrders = FXCollections.observableArrayList();
    private ObservableList<String[]> ordersInProcess = FXCollections.observableArrayList();

    private ArrayList<Order> orders = new ArrayList<>();

    public void initialize() {

        session = Session.getInstance();
        user = session.getUser();
        table = session.getSelectedTable();

        orders = session.getData(table.getTableID());

        inProcessOrdersNum.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        inProcessOrdersTotal.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        readyOrdersNum.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        readyOrdersTotal.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        updateOrderLists();
        readyOrdersTbl.setItems(readyOrders);
        ordersInProcessTbl.setItems(ordersInProcess);

    }
    @FXML
    private void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        LoaderManager lm = new LoaderManager();
        lm.goBack("Table-layout.fxml", actionEvent);
    }
    @FXML
    private void onViewOrderBtn(ActionEvent actionEvent) {
    }
    public void updateOrderLists(){
       for(Order order : orders) {
           String[] parts = new String[2];
           parts[0] = String.valueOf(order.getOrderNum());
           ArrayList<OrderItem> orderItem = order.getOrderItems();
           float total = 0;
           for (OrderItem item : orderItem){
               total += item.getQuantity()*item.getItem().getPrice();
           }
           parts[1] = String.format("%.2f", total);
           if(order.getOrderStatus().equalsIgnoreCase("READY")) {
               for(String part : parts){
                   System.out.println(part + " ");
               }
               System.out.println();
               readyOrders.add(parts);
           } else {
               for(String part : parts){
                   System.out.println(part + " ");
               }
               System.out.println();
               ordersInProcess.add(parts);
           }
       }
    }
}
