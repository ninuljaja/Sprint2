package com.sprint2.gui;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.util.converter.LocalDateTimeStringConverter;

public class ActivityLogging {
    
    private static List<Log> logs = new LinkedList<Log>();
    private static String LOGS_FILENAME = "logs.csv";
    private static String delimiter = ";";
    private static LocalDateTimeStringConverter converter = new LocalDateTimeStringConverter();

    public static List<Log> getLogs() {
        return logs;
    }

    public static void AddLog(String title, String text)
    {
        Log newLog = new Log(title, text);
        logs.add(newLog);
        SaveLog(newLog);
    }

    public static class Log{
        public String title;
        public String text;
        public LocalDateTime time;
        
        public Log(String title, String text)
        {
            this.title = title;
            this.text = text;
            time = LocalDateTime.now();
        }

        public Log(String title, String text, String time)
        {
            this.title = title;
            this.text = text;
            this.time = converter.fromString(time);
        }
    }

    private static void SaveLog(Log log)
    {
        FileWriter writer;
        try { 
            writer = new FileWriter(LOGS_FILENAME, true);
            writer.write(converter.toString(log.time) + delimiter + log.title + delimiter + log.text + "\n");
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
    }

    public static void LoadLogs()
    {
        Scanner scan;
        try {
            scan = new Scanner(new File(LOGS_FILENAME));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Log file " + LOGS_FILENAME + " was not found. Skipping loading of logs.");
            return;
        }
        
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] strings = line.split(delimiter);
            logs.add(new Log(strings[1], strings[2], strings[0]));
        }
        scan.close();
    }
}
