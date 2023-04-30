package com.sprint2.gui;


import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class OrdersViewController {
    @FXML
    private Label tableNum, waiterLbl;
    @FXML
    private TableView<String[]> readyOrdersTbl, ordersInProcessTbl, orderListTbl;
    @FXML
    private TableColumn<String[], String> inProcessOrdersNum, inProcessOrdersTotal, readyOrdersTotal,readyOrdersNum;
    @FXML
    private TableColumn<String[], String> itemColumn, addonsColumn, commentsColumn, priceColumn;
    private ArrayList<TableColumn<String[], String>> tableColumns;
    @FXML
    private Button viewOrderBtn, markOrderReadyBtn, markOrderCompleteBtn;
    @FXML
    private Group activeOrders;
    private Session session = null;
    private Employee user = null;
    private Table table = null;
    private ObservableList<String[]> readyOrders;
    private ObservableList<String[]> ordersInProcess;
    ObservableList<String[]> orderList;

    private ArrayList<Order> orders;
    private ArrayList<Order> ordersReady,inProcessOrders;


    public void initialize() throws FileNotFoundException {

        session = Session.getInstance();
        user = session.getUser();
        table = session.getSelectedTable();
        tableNum.setText("Table " + table.getTableID());
        orders = new ArrayList<>();
        ordersReady= new ArrayList<>();
        inProcessOrders= new ArrayList<>();
        tableColumns = new ArrayList<>();
        readyOrders = FXCollections.observableArrayList();
        ordersInProcess = FXCollections.observableArrayList();
        orderList = FXCollections.observableArrayList();
        session.loadActiveOrders();
        orders = session.getData(table.getTableID());
        inProcessOrdersNum.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        inProcessOrdersTotal.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        readyOrdersNum.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[0]));
        readyOrdersTotal.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()[1]));
        updateOrderLists();
        tableColumns.addAll(Arrays.asList(itemColumn, addonsColumn, commentsColumn, priceColumn));
        readyOrdersTbl.setItems(readyOrders);
        ordersInProcessTbl.setItems(ordersInProcess);
        viewOrderBtn.setText("View Order");
        viewOrderBtn.setDisable(true);
        markOrderReadyBtn.setDisable(true);
        markOrderCompleteBtn.setDisable(true);
        orderListTbl.setVisible(false);
        activeOrders.setVisible(true);
        waiterLbl.setText("");

    }
    @FXML
    private void onGoBackBtn(ActionEvent actionEvent) throws IOException {
        LoaderManager lm = new LoaderManager();
        lm.goBack("Table-layout.fxml", actionEvent);
    }
    @FXML
    private void onViewOrderBtn() throws FileNotFoundException {
        if(viewOrderBtn.getText().equalsIgnoreCase("View Order")) {
            String[] selectedRow = new String[2];
            ArrayList<Order> order = new ArrayList<>();
            int selectedIndex1 = readyOrdersTbl.getSelectionModel().getSelectedIndex();
            int selectedIndex2 = ordersInProcessTbl.getSelectionModel().getSelectedIndex();
            int selectedIndex = 0;
            if (selectedIndex1 >= 0) {
                selectedIndex = selectedIndex1;
                order = ordersReady;
                selectedRow = readyOrdersTbl.getItems().get(selectedIndex);
            } else if(selectedIndex2 >= 0) {
                selectedIndex = selectedIndex2;
                order = inProcessOrders;
                selectedRow = ordersInProcessTbl.getItems().get(selectedIndex);
            }
            if (!selectedRow[0].isEmpty()) {
                try {
                    orderListTbl.getItems().removeAll();
                    orderList.clear();
                    ArrayList<OrderItem> orderItems = order.get(selectedIndex).getOrderItems();
                    orderListTbl.setVisible(true);
                    Employee emp = session.findEmployee(String.valueOf(order.get(selectedIndex).getWaiterID()));
                    waiterLbl.setText("Waiter:\n" + emp.getFirstName() + " " + emp.getLastName());
                    activeOrders.setVisible(false);
                    session.viewOrder(tableColumns, orderList, orderItems, orderListTbl);
                    viewOrderBtn.setText("Back to Orders List");
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        } else {
            initialize();
        }

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
               ordersReady.add(order);
               readyOrders.add(parts);
           } else {
               inProcessOrders.add(order);
               ordersInProcess.add(parts);
           }
       }
    }

    public void onMarkOrderReadyBtn(ActionEvent actionEvent) throws FileNotFoundException {
        String[] selectedRow = new String[2];
        int selectedIndex = ordersInProcessTbl.getSelectionModel().getSelectedIndex();
        Order order = null;
        if (selectedIndex >= 0) {
            selectedRow = ordersInProcessTbl.getItems().get(selectedIndex);
            order = inProcessOrders.get(selectedIndex);
            selectedRow = ordersInProcessTbl.getItems().get(selectedIndex);
        }
        if (!selectedRow[0].isEmpty() && order != null) {
            session.updateOrderStatus(order, "READY");
            initialize();
        }
    }

    public void onMarkOrderCompleteBtn(ActionEvent actionEvent) throws FileNotFoundException {
        String[] selectedRow = new String[2];
        int selectedIndex = readyOrdersTbl.getSelectionModel().getSelectedIndex();
        Order order = null;
        if (selectedIndex >= 0) {
            selectedRow = readyOrdersTbl.getItems().get(selectedIndex);
            order = ordersReady.get(selectedIndex);
            selectedRow = readyOrdersTbl.getItems().get(selectedIndex);
        }
        if (!selectedRow[0].isEmpty() && order != null) {
            session.updateOrderStatus(order, "COMPLETED");
            initialize();
        }
    }

    public void onReadyOrdersClick(MouseEvent mouseEvent) {
        markOrderReadyBtn.setDisable(true);
        markOrderCompleteBtn.setDisable(false);
        viewOrderBtn.setDisable(false);
    }

    public void onInProcessOrdersClick() throws FileNotFoundException {
        markOrderReadyBtn.setDisable(false);
        markOrderCompleteBtn.setDisable(true);
        viewOrderBtn.setDisable(false);
    }
}
