package having.fun.with.flatmapinaction.future;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * <b>{@code CompletableFuture.flatMap(Function<T, CompletableFuture<U>>)}</b> combines 2 <b>CompletableFuture</b> objects.
 * <p/>
 * {@code
 *     future2 = future1.flatMap(v1 -> // create future2)
 * }
 * <p/>
 * The mapper function {@code Function<T, CompletableFuture<U>} has the access to the value of future2.
 * With this value (T) you can decide how and what to generate future2 {@code (CompletableFuture<U>)}. in the mapper function.
 */
public class O2_Future_with_flatMap {

    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> futureNum1 = CompletableFuture.supplyAsync(() -> {
            wait(3);
            return 3;
        });

        CompletableFuture<String> starOrHash1 = futureNum1.thenCompose(n -> futureStarHash(n));

        CompletableFuture<Void> futureHandled1 = starOrHash1.thenAccept(str -> System.out.println(str));  // ***


        CompletableFuture<Integer> futureNum2 = CompletableFuture.supplyAsync(() -> {
            wait(1);
            return -3;
        });

        CompletableFuture<String> starOrHash2 = futureNum2.thenCompose(n -> futureStarHash(n));

        CompletableFuture<Void> futureHandled2 = starOrHash2.thenAccept(str -> System.out.println(str));// ###


        // force JVM to wait for the completion of future value handling.
        futureHandled1.get();
        futureHandled2.get();

    }

    static CompletableFuture<String> futureStarHash(int n) {
        return CompletableFuture.supplyAsync(() -> {
            wait(Math.abs(n));
            return starHash(n);
        });
    }

    static String starHash(int num) {
        String symbol = num > 0 ? "*" : "#";
        return Collections.nCopies(Math.abs(num), symbol).stream()
                .collect(Collectors.joining());
    }

    static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
