package com.sprint2.gui;

public class Session {
    private static Session instance = null;
    private Employee user;
    private String mode;
    private Table selectedTable;

    private Session() {
        ActivityLogging.LoadLogs();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Employee getUser() {
        return user;
    }

    public void setUser(Employee user) {
        this.user = user;
    }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setSelectedTable(Table selectedTable) {
        this.selectedTable = selectedTable;
    }

    public Table getSelectedTable() {
        return selectedTable;
    }
}
