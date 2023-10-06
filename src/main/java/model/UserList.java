/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import view.Validation;

/**
 *
 * @author Tran HaF
 */
public class UserList {

    protected HashMap<String, String> users = new HashMap();
    private static final String FILE_NAME = "user.txt";

    public UserList() {
        users = new HashMap<>();
        loadUsers();
    }

    public boolean addUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }
        users.put(username, password);
        saveUsers();
        return true;
    }

    public boolean checkUser(String username, String password) {
        String correctPassword = users.get(username);
        return correctPassword != null && correctPassword.equals(password);
    }

    private void loadUsers() {
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void saveUsers() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            Set<String> setKey = users.keySet();

            for (String key : setKey) {
                bw.write(key + ":" + users.get(key));
                bw.newLine();
            }

            bw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
