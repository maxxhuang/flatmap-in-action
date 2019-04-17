package having.fun.with.flatmapinaction.future;

import having.fun.with.flatmapinaction.model.Account;
import having.fun.with.flatmapinaction.model.AccountSummary;
import having.fun.with.flatmapinaction.model.User;

import java.util.concurrent.CompletableFuture;

public class O3_Future_using_flatMap_and_map {


    public static class AccountService {

        public CompletableFuture<Account> getAccountFromAccountService(String accountId) {
            return CompletableFuture.supplyAsync(() ->
                    new Account(accountId, "U00001", 2000.0)
            );
        }

        public CompletableFuture<User> getUserFromUserService(String userId) {
            return CompletableFuture.supplyAsync(() ->
                    new User(userId, "Richard")
            );
        }

    }


    ///////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) throws Exception {
        CompletableFuture<AccountSummary> accountInfo1 = retrieveAccountInfo("A00001");
        System.out.println(accountInfo1.get());
    }

    public static CompletableFuture<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        return service.getAccountFromAccountService(accountId)
                .thenCompose(account -> service.getUserFromUserService(account.getAccountId())
                        .thenApply(user -> new AccountSummary(user.getUserId(), user.getUserName(),
                                account.getAccountId(), account.getBalance())));
    }

}
