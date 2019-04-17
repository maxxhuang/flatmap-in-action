package having.fun.with.flatmapinaction.model;

public class Account {

    private String accountId;
    private String userId;

    private double balance;

    public Account(String accountId, String userId, double balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.balance = balance;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", userId='" + userId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
