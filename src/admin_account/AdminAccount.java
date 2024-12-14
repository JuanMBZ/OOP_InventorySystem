package admin_account;

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

}
