package having.fun.with.flatmapinaction.optional.service;

import java.util.Optional;

public class AccountService {

    public Optional<String> getUserName(String accountId) {
        return (Integer.parseInt(accountId) % 2 == 0) ?
                Optional.empty() : Optional.of("Richard");
    }

    public Optional<Double> getBalance(String accountId) {
        return Optional.of(2000.0);
    }

}
