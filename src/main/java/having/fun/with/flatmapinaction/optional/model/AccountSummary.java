package having.fun.with.flatmapinaction.optional.model;

public class AccountSummary {

    private String userId;
    private String userName;
    private String accountId;
    private double blance;


    public AccountSummary(String userId, String userName, String accountId, double blance) {
        this.userId = userId;
        this.userName = userName;
        this.accountId = accountId;
        this.blance = blance;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBlance() {
        return blance;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", blance=" + blance +
                '}';
    }
}
