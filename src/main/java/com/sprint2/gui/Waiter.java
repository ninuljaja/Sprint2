package com.sprint2.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waiter extends Employee {

    private ArrayList<Table> tables = new ArrayList<>();

    private List<OrderItem> orderItems = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public Waiter(String[] waiter) {
        super(waiter);
        updateAssignedTables();
    }
    public Waiter(Employee waiter) {
        super(waiter);

    }

    public  ArrayList<Table> getAssignedTable (){
        updateAssignedTables();
        return tables;
    }
    public void updateAssignedTables(){
        try {
            String dataLine = "";
            File myFile = new File("Tables.csv");
            Scanner scan = new Scanner(myFile);
            scan.nextLine();
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                String[] line = dataLine.split(",");
                if (line[1].equalsIgnoreCase(String.valueOf(employeeID))) {
                   tables.add(new Table(line));
                }
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }

    public void createOrder(Table table, ArrayList<OrderItem> orderItems){

            try {
                int orderNumber = lastOrderNumber() + 1;
                String orderTime = formatter.format(LocalDateTime.now());
                String[] currentOrder = new String[5];
                currentOrder[0] = String.valueOf(orderNumber);
                currentOrder[1] = orderTime;
                currentOrder[2] = table.getTableID();
                currentOrder[3] = "IN_PROCESS";
                currentOrder[4] = String.valueOf(getEmployeeID());
                table.addToActiveOrders(currentOrder, orderItems);

                FileWriter writer = new FileWriter("Orders.csv", true);
          //      String currentOrderString = Arrays.toString(currentOrder); // "[apple, banana, cherry]"

               // currentOrderString = currentOrderString.substring(1, currentOrderString.length() - 1).replaceAll(", ", ",");
                writer.write(String.join(",", currentOrder) + "\n");
                writer.close();

                writer = new FileWriter("OrderDetails.csv", true);

                for(OrderItem items : orderItems) {
                    writer.write(currentOrder[0] + "," + items.getItem().getItemName() + "," + items.getAddons() + "," +
                            items.getComments() + "," + items.getQuantity() + "\n");

                }
                writer.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }


    }
    public OrderItem addOrderItem(Item item, int quantity, String addons, String comments){
        return new OrderItem(item, quantity, addons, comments);
    }

    public int lastOrderNumber() {
        int lastNumber = 0;
        try {
            File file = new File("Orders.csv");
            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(",");
                lastNumber = Integer.parseInt(data[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        return lastNumber;
    }
}
