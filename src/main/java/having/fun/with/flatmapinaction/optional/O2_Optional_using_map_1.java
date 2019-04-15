package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.service.AccountInfo;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O2_Optional_using_map_1 {

    public static void main(String[] args) {

        Optional<AccountInfo> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountInfo> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountInfo> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        Optional<Optional<AccountInfo>> nestedOptAccountInfo = optName.map(name -> {
            Optional<Double> optBalance = service.getBalance(accountId);

            return optBalance.map(balance -> new AccountInfo(accountId, name, balance));

        });

        if (nestedOptAccountInfo.isPresent()) {
            return nestedOptAccountInfo.get();
        } else {
            return Optional.empty();
        }

        // the above if-else statement can be replaced with the following one liner using Optional.orElse:
        //
        // return nestedOptAccountInfo.orElse(Optional.empty());
    }

}
