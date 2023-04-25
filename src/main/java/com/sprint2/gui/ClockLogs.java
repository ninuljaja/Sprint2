package com.sprint2.gui;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ClockLogs {

    private List<LocalDateTime> clockIns;
    private List<LocalDateTime> clockOuts;
    private boolean isClockedIn = false;

    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;

    private EventType type;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public enum EventType {
        CLOCK_IN,
        CLOCK_OUT
    }
    public ClockLogs() {
        this.clockIns = new ArrayList<>();
        this.clockOuts = new ArrayList<>();
    }


    public LocalDateTime getClockInTime() {
        return clockInTime;
    }

    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }

    public void clockIn(String employeeID) {
        clockInTime = LocalDateTime.now();
        this.clockIns.add(clockInTime);
        saveClockInOutTime(employeeID, EventType.CLOCK_IN.name(), formatter.format(clockInTime));
        isClockedIn = true;
    }

    public void clockOut(String employeeID) {
        clockOutTime = LocalDateTime.now();
        this.clockOuts.add(clockOutTime);
        saveClockInOutTime(employeeID, EventType.CLOCK_OUT.name(), formatter.format(clockInTime));
        isClockedIn = false;

    }

    public String lastAction() {
        if (!clockIns.isEmpty()) {
            int lastRecord = clockIns.size() - 1;
            if (isClockedIn){
                return "Last action: Clock In at " + formatter.format(clockIns.get(lastRecord));
            } else {
                return "Last action: Clock Out at " + formatter.format(clockOuts.get(lastRecord));
            }
        } else {
            return "";
        }
    }
    public boolean isClockedIn(){
        return isClockedIn;
    }

    public void saveClockInOutTime(String employeeID, String typeOfEvent, String time){
        try {

            FileWriter writer = new FileWriter("ClockIn_ClockOut_Logs.csv", true);

            writer.write(employeeID + "," + typeOfEvent + "," + time + "\n");
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Error: " + e.getMessage());
        }


    }


}