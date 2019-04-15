package having.fun.with.flatmapinaction.optional.service;

public class AccountInfo {

    private String accountId;
    private String userName;
    private Double balance;


    public AccountInfo(String accountId, String userName, Double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = balance;
    }


    public String getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public Double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountId='" + accountId + '\'' +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
