package having.fun.with.flatmapinaction.optional;

import having.fun.with.flatmapinaction.model.Account;
import having.fun.with.flatmapinaction.model.AccountSummary;
import having.fun.with.flatmapinaction.model.User;

import java.util.Optional;

public class O4_Optional_using_flatMap_and_map {


    public static class AccountService {

        public Optional<Account> getAccountFromAccountService(String accountId) {
            return Optional.of(
                    new Account(accountId, "U00001", 2000.0)
            );
        }

        public Optional<User> getUserFromUserService(String userId) {
            return Optional.of(
                    new User(userId, "Richard")
            );
        }

    }


    ///////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        Optional<AccountSummary> accountInfo1 = retrieveAccountInfo("A00001");
        System.out.println(accountInfo1);
    }

    public static Optional<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        return service.getAccountFromAccountService(accountId)
                .flatMap(account -> service.getUserFromUserService(account.getAccountId())
                        .map(user -> new AccountSummary(user.getUserId(), user.getUserName(),
                                account.getAccountId(), account.getBalance())));
    }

}
