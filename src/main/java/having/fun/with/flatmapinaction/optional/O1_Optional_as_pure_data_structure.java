package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.service.AccountInfo;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O1_Optional_as_pure_data_structure {

    public static void main(String[] args) {

        Optional<AccountInfo> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountInfo> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountInfo> retrieveAccountInfo(String accountId) {

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


        AccountInfo info = new AccountInfo(accountId, name, balance);

        return Optional.of(info);

    }


}
