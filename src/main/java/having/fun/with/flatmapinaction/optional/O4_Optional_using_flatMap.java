package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.model.AccountSummary;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O4_Optional_using_flatMap {

    public static void main(String[] args) {

        Optional<AccountSummary> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountSummary> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        Optional<AccountSummary> optAccountInfo = optName.flatMap(name -> {
            Optional<Double> optBalance = service.getBalance(accountId);
            return optBalance.map(balance -> new AccountSummary(accountId, name, balance));
        });

        return optAccountInfo;
    }

    public static Optional<AccountSummary> retrieveAccountInfo_using_map1(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        Optional<Optional<AccountSummary>> nestedOptAccountInfo = optName.map(name -> {
            Optional<Double> optBalance = service.getBalance(accountId);
            return optBalance.map(balance -> new AccountSummary(accountId, name, balance));
        });

        if (nestedOptAccountInfo.isPresent()) {
            return nestedOptAccountInfo.get();
        } else {
            return Optional.empty();
        }

    }

}
