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
    public static Employee authenticateUser(String user, String pass) {

        for (Employee employee : GUIApplication.getEmployeeDatabase().getEmployees())
        {
            if (user.equals(employee.getUsername()) && pass.equals(employee.getPassword()))
            {
                return employee;
            }
        }
        return null;
    }
}

