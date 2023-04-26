package com.sprint2.gui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Authentication {
    /**This method authenticates the user with the username and password passed from the interface as the input parameters.
     *
     * @param user
     * @param pass
     * @return
     */
    public static String[] authenticateUser(String user, String pass) {
        try {
            String dataLine = "";
            File myFile = new File("Employee.csv");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextLine()) {
                dataLine = scan.nextLine();

                // Split the string by comma
                String[] line = dataLine.split(",");
                if (line[7].equals(user)) {
                    if (line[8].equals(pass)) {
                        return line;
                    }
                }
            }
            scan.close();

        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
        return null;
    }

}

