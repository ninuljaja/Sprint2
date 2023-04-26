package com.sprint2.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ClockLogs {
    private boolean isClockedIn;
    private LocalDateTime clockInTime;
    private LocalDateTime clockOutTime;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public enum EventType {
        CLOCK_IN,
        CLOCK_OUT
    }
    public ClockLogs() {
    }
    public LocalDateTime getClockInTime() {
        return clockInTime;
    }
    public LocalDateTime getClockOutTime() {
        return clockOutTime;
    }
    public void clockIn(int employeeID) {
        clockInTime = LocalDateTime.now();
   //     this.clockIns.add(clockInTime);
        saveClockInOutTime(employeeID, EventType.CLOCK_IN.name(), formatter.format(clockInTime));
        isClockedIn = true;
    }

    public void clockOut(int employeeID) {
        clockOutTime = LocalDateTime.now();
    //    this.clockOuts.add(clockOutTime);
        saveClockInOutTime(employeeID, EventType.CLOCK_OUT.name(), formatter.format(clockOutTime));
        isClockedIn = false;

    }

    public String lastAction(int employeeID) {
        String lastAction = "";
        String[] lastRecord = getLastRecord(employeeID);
        if (lastRecord == null){
            isClockedIn = false;
        } else if(lastRecord[1].equals("CLOCK_IN")){
            isClockedIn = true;
            lastAction = "Last action: Clock In at " + lastRecord[2];
        } else {
            isClockedIn = false;
            lastAction =  "Last action: Clock Out at " + lastRecord[2];
        }
        return lastAction;
    }
    public boolean isClockedIn(){
        return isClockedIn;
    }

    public void saveClockInOutTime(int employeeID, String typeOfEvent, String time){
        try {
            FileWriter writer = new FileWriter("ClockIn_ClockOut_Logs.csv", true);
            writer.write(""+ employeeID + "," + typeOfEvent + "," + time + "\n");
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getLastRecord(int employeeID) {
        String[] lastRecord = null;

        try {
            String dataLine;
            File myFile = new File("ClockIn_ClockOut_Logs.csv");
            Scanner scan = new Scanner(myFile);
            String[] line;
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();
                // Split the string by comma
                line = dataLine.split(",");
                if (line[0].equals(String.valueOf(employeeID))) {
                    lastRecord = line;
                }
            }
            scan.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return lastRecord;
    }
}