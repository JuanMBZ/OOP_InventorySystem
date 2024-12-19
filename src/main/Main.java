package main;

import operation.*;
import products.*;
import userinterface.*;
import java.util.Scanner;
import java.io.*;

public class Main {
    

    public static void main(String[] args) throws IOException, InterruptedException {
        int key;
        String dataFile = "./src/database/inventory.in";
        String userAuth;
        
        //Log in
        LogInFrame logIn = new LogInFrame();
        logIn.setVisible(true);
        logIn.makeWait();
        userAuth = logIn.getUserAuth();
        if(userAuth.equals("cancel"))
            return;
        ArraysDataStruct productList = new ArraysDataStruct();
        Features features = new Features(productList, dataFile);
        //read from data file
        features.readDataFromFile(dataFile);
        //Start GUI
        InventoryDisplay inventoryGUI =new InventoryDisplay(productList, features, userAuth);
        inventoryGUI.setVisible(true);

    }
}
