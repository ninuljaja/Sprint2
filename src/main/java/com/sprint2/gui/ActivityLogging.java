package com.sprint2.gui;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ActivityLogging {
    
    private static List<Log> logs = new LinkedList<Log>();

    public static List<Log> getLogs() {
        return logs;
    }

    public static void AddLog(String title, String text)
    {
        logs.add(new Log(title, text));
    }

    static class Log{
        public String title;
        public String text;
        public LocalDateTime time;
        
        public Log(String title, String text)
        {
            this.title = title;
            this.text = text;
            time = LocalDateTime.now();
        }
    }
}
