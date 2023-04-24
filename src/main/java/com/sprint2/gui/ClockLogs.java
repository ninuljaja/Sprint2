package com.sprint2.gui;

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

    public void clockIn() {
        clockInTime = LocalDateTime.now();
        this.clockIns.add(clockInTime);
        isClockedIn = true;
    }

    public void clockOut() {
        clockOutTime = LocalDateTime.now();
        this.clockOuts.add(clockOutTime);
        isClockedIn = false;
    }

    public String lastAction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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


}