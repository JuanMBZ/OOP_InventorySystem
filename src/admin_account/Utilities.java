package admin_account;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Working na lahat to
 * 
 *      searchAdminAccount() - bale i-s-search niya yung username_log at password_log sa AdminAccount arraylist
 *                           - return true if nahanap, false naman kung hindi
 * 
 *      accessAdminAccounts() - bale kukuhanin neto yung data sa pinasa niyong accounts_filepath
 *                            - bubuohin neto ang isang arraylist gamit yung data sa accounts.txt file
 *                            - after mabuo yung arraylist i-r-return na neto
 *                            - pasa niyo din dito yung filepath ng accounts.txt from folder database
 * 
 *      saveAdminAccounts() - bale i-s-save neto yung data ng accounts_to_save arraylist pinasa niyong accounts_filepath
 *                          - NOTE: i-o-override neto yung laman ng accounts.txt file
 *                          - pasa niyo din dito yung filepath ng accounts.txt from folder database
 * 
 *      logInTerminal_UI() - kung gusto niyo i-try sa terminal ang pag-logIn, type Utilities.logInTerminal() sa isang main() function
 * 
 */
public abstract class Utilities {

    public static boolean searchAdminAccount(ArrayList<AdminAccount> accounts, String username_log, String password_log) {
        for(AdminAccount current_account : accounts) {
            if(current_account.getUsername().equals(username_log) &&
               current_account.getPassword().equals(password_log)) {
                System.out.println("Found");
                return true;
            }
        }
        System.out.println("Not Found");
        return false;
    }

    public static ArrayList<AdminAccount> accessAdminAccounts(String accounts_filepath) {
        ArrayList<AdminAccount> accounts = new ArrayList<>(); 
        final String filepath = accounts_filepath;

        try {
            File input_file = new File(filepath);
            Scanner input_scanner = new Scanner(input_file);
            
            while(input_scanner.hasNext()) {
                String account_from_file = input_scanner.nextLine();
                String cleaned_account_from_file[] =  account_from_file.split(", ", 3);
                
                AdminAccount current_account = new AdminAccount(cleaned_account_from_file[1],
                                                  cleaned_account_from_file[2], 
                                                  Integer.parseInt(cleaned_account_from_file[0]));
                accounts.add(current_account);
            }
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveAdminAccounts(ArrayList<AdminAccount> accounts_to_save, String accounts_filepath) {
        try(FileWriter file_writer = new FileWriter(accounts_filepath)) {
            for(AdminAccount current_account : accounts_to_save) {
                // # Uncomment for debugging
                /*  System.out.println(current_account.getAccountID() + ", " +
                 *  current_account.getUsername() + ", " +
                 *  current_account.getPassword());
                 */
                file_writer.write(current_account.getAccountID() + ", " +
                                  current_account.getUsername() + ", " +
                                  current_account.getPassword() + "\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void logInTerminal_UI(String accounts_filepath) {
        ArrayList<AdminAccount> test_file = Utilities.accessAdminAccounts(accounts_filepath);
        Scanner scanner_var = new Scanner(System.in);
        String username = "";
        String password = "";

        System.out.print("\n\n\n\n\tUsername: ");
        username = scanner_var.nextLine();
        System.out.print("\n\tPassword: ");
        password = scanner_var.nextLine();

        Utilities.searchAdminAccount(test_file, username, password);
    }
    
    public static boolean addAdminAccount(ArrayList<AdminAccount> accounts, String newUsername, String newPassword) {
        for(AdminAccount current_account: accounts) {   //check if new username already exists
            if(current_account.getUsername().equals(newUsername))
                return false;
        }
        accounts.add(new AdminAccount(newUsername, newPassword, accounts.get(accounts.size()-1).getAccountID()+1));
        return true;
    }
    
    public static boolean deleteAdminAccount(ArrayList<AdminAccount> accounts, String deleteUsername) {
        for(AdminAccount current_account: accounts) {   //find username in accounts already exists
            if(current_account.getUsername().equals(deleteUsername)) {
                accounts.remove(current_account);
                return true;
            }    
        }
        return false;
    }
    
    public static boolean checkEmployeeCredentials(String filepath, String username, String password) {
        try {
            File input_file = new File(filepath);
            Scanner input_scanner = new Scanner(input_file);
            String employee_info[] =  input_scanner.nextLine().split(", ", 2);
            if(username.equals(employee_info[0]) && password.equals(employee_info[1]))
                return true;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
