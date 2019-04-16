package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.model.AccountSummary;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O3_Optional_using_map_2 {

    public static void main(String[] args) {

        Optional<AccountSummary> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountSummary> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        Optional<AccountSummary> optAccountInfo = optName.map(name -> {
            Optional<Double> optBalance = service.getBalance(accountId);

            Optional<AccountSummary> optInfo = optBalance.map(balance -> new AccountSummary(accountId, name, balance));

            if (optInfo.isPresent()) return optInfo.get();
            else return null;
        });

        return optAccountInfo;
    }


}
