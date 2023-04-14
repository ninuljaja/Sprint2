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

        String[] toReturn = null;
        try {
            String dataline = "";

            File myFile = new File("Employee.csv");
            Scanner scan = new Scanner(myFile);

            while (scan.hasNextLine()) {
                dataline = scan.nextLine();

                // Split the string by comma
                String[] line = dataline.split(",");
                if (line[4].equals(user)) {
                    if (line[5].equals(pass)) {
                        toReturn = new String[]{line[0], line[1], line[2], line[3]};
                    }
                    return toReturn;
                }
            }
            scan.close();

        } catch (IOException ioex) {
            System.out.println("Error: " + ioex.getMessage());
        }
        return toReturn;

    }

}

