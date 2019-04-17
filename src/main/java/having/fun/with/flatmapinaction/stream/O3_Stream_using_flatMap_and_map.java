package having.fun.with.flatmapinaction.stream;

import having.fun.with.flatmapinaction.model.Account;
import having.fun.with.flatmapinaction.model.AccountSummary;
import having.fun.with.flatmapinaction.model.User;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class O3_Stream_using_flatMap_and_map {


    public static class AccountService {

        public List<Account> getAccountFromAccountService(String accountId) {
            return Collections.singletonList(
                    new Account(accountId, "U00001", 2000.0)
            );
        }

        public List<User> getUserFromUserService(String userId) {
            return Collections.singletonList(
                    new User(userId, "Richard")
            );
        }

    }


    ///////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        List<AccountSummary> accountInfo1 = retrieveAccountInfo("A00001");
        System.out.println(accountInfo1);
    }

    public static List<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        return service.getAccountFromAccountService(accountId).stream()
                .flatMap(account -> service.getUserFromUserService(account.getAccountId()).stream()
                        .map(user -> new AccountSummary(user.getUserId(), user.getUserName(),
                                account.getAccountId(), account.getBalance()))).collect(toList());
    }

}
