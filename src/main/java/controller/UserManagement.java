/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UserList;
import view.Menu;
import view.Validation;

/**
 *
 * @author Tran HaF
 */
public class UserManagement extends Menu<String> {

    static String[] menu = {"Create new account", "Login system", "Exit"};
    static UserList userlist = new UserList();

    public UserManagement() {
        super("\n\n=== USER MANAGEMENT SYSTEM ===", menu);
    }

    @Override
    public void execute(int n){
        switch (n) {
            case 1:
                creatAcc();
                break;
            case 2:
                loginSystem();
                break;
            case 3:
                System.out.println("___<3___ Thank you ___<3___");
                System.out.println("Exiting......");
                System.exit(0);
            default:
                throw new AbstractMethodError();

        }
    }

    private void creatAcc() {
        String username = Validation.checkUserName("Enter user name: ");
        String password = Validation.checkPassword("Enter password: ");
        if (userlist.addUser(username, password)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void loginSystem() {
        String username = Validation.checkUserName("Enter user name: ");
        String password = Validation.checkPassword("Enter password: ");
        if (userlist.checkUser(username, password)) {
            System.out.println("Login successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
