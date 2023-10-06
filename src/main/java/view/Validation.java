/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Common.Library;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tran HaF
 */
public class Validation {

    public Validation() {
    }

    public static String checkUserName(String msg) {
        while (true) {
            String result = Library.getString(msg);
            if (result.length() < 5 || result.contains(" ")) {
                System.out.println("Please enter username least at 5 character and no space");
            } else {
                return result;
            }
        }
    }

    public static String checkPassword(String msg) {
        while (true) {
            String result = Library.getString(msg);
            if (result.length() < 6 || result.contains(" ")) {
                System.out.println("Please enter username least at 6 character and no space! ");
            } else {
                return result;
            }
        }
    }

}
