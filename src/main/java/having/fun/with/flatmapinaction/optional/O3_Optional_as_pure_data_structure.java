package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.model.AccountSummary;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O3_Optional_as_pure_data_structure {

    public static void main(String[] args) {

        Optional<AccountSummary> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountSummary> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        if (!optName.isPresent()) {
            return Optional.empty();
        }

        String name = optName.get();

        Optional<Double> optBalance = service.getBalance(accountId);


        if (!optBalance.isPresent()) {
            return Optional.empty();
        }

        Double balance = optBalance.get();


        AccountSummary info = new AccountSummary(accountId, name, balance);

        return Optional.of(info);

    }


}
