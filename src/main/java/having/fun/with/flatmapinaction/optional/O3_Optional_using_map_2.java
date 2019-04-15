package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.optional.service.AccountInfo;
import having.fun.with.flatmapinaction.optional.service.AccountService;

import java.util.Optional;

public class O3_Optional_using_map_2 {

    public static void main(String[] args) {

        Optional<AccountInfo> accountInfo1 = retrieveAccountInfo("001");
        Optional<AccountInfo> accountInfo2 = retrieveAccountInfo("002");

        System.out.println(accountInfo1);
        System.out.println(accountInfo2);
    }

    public static Optional<AccountInfo> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        Optional<String> optName = service.getUserName(accountId);

        Optional<AccountInfo> optAccountInfo = optName.map(name -> {
            Optional<Double> optBalance = service.getBalance(accountId);

            Optional<AccountInfo> optInfo = optBalance.map(balance -> new AccountInfo(accountId, name, balance));

            if (optInfo.isPresent()) return optInfo.get();
            else return null;
        });

        return optAccountInfo;
    }


}
