package having.fun.with.flatmapinaction.reactor;

import having.fun.with.flatmapinaction.model.Account;
import having.fun.with.flatmapinaction.model.AccountSummary;
import having.fun.with.flatmapinaction.model.User;
import reactor.core.publisher.Mono;

public class O1_Mono_using_flatMap_and_map {


    public static class AccountService {

        public Mono<Account> getAccountFromAccountService(String accountId) {
            return Mono.just(
                    new Account(accountId, "U00001", 2000.0)
            );
        }

        public Mono<User> getUserFromUserService(String userId) {
            return Mono.just(
                    new User(userId, "Richard")
            );
        }

    }


    ///////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        Mono<AccountSummary> accountInfo1 = retrieveAccountInfo("A00001");
        accountInfo1.subscribe(summary -> System.out.println(summary));
    }

    public static Mono<AccountSummary> retrieveAccountInfo(String accountId) {

        AccountService service = new AccountService();

        return service.getAccountFromAccountService(accountId)
                .flatMap(account -> service.getUserFromUserService(account.getAccountId())
                        .map(user -> new AccountSummary(user.getUserId(), user.getUserName(),
                                account.getAccountId(), account.getBalance())));
    }

}
