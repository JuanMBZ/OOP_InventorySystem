package admin_account;

import static admin_account.Utilities.logInTerminal_UI;
import java.util.ArrayList;

public class AdminAccount{
    private String username;
    private String password;
    private int account_id;

    public AdminAccount() {}

    public AdminAccount(String username, String password, int account_id) {
        this.username = username;
        this.password = password;
        this.account_id = account_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountID(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public int getAccountID() {
        return this.account_id;
    }
    
    public static void main(String args[]) {
        String accounts_filepath = "./src/database/admin_accounts.txt";
        ArrayList<AdminAccount> accounts = Utilities.accessAdminAccounts(accounts_filepath);
        Utilities.logInTerminal_UI(accounts_filepath);
        Utilities.addAdminAccount(accounts, "Test", "Pass");
        //Utilities.deleteAdminAccount(accounts, "Juan");
        System.out.println("Employee = "+ Utilities.checkEmployeeCredentials("./src/database/employee.txt", "employee", "password"));
        Utilities.saveAdminAccounts(accounts, accounts_filepath);
    }
}
