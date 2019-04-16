package having.fun.with.flatmapinaction.future;

import java.util.concurrent.CompletableFuture;

/**
 * <b>{@link java.util.concurrent.CompletableFuture}</b> does not have map/flatMap defined.
 * However, {@code CompletableFuture<T>} does have similar methods to map/flatMamp.
 * <ul>
 *     <li>map: <b>{@code CompletableFuture.thenApply(Function<T, U> mapper)}</b></li>
 *     <li>flatMap: <b>{@code CompletableFuture.thenCompose(Function<T, CompletableFuture<U>> mapper)}</b></li>
 * </ul>
 * <b>{@code CompletableFuture<T>}</b> is a holder containing a value that will be available sometime later.
 * <p/>
 * <b>{@code CompletableFuture.map(Function<T, U> mapper)}</b> transforms <b>the future value</b>
 * from CompletableFuture by invoking the mapper function.
 */
public class O1_Future_with_map {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> futureStr1 = CompletableFuture.supplyAsync(() -> {
            wait(2);
            return "123";
        });
        CompletableFuture<Integer> futureNum1 = futureStr1.thenApply(str -> Integer.parseInt(str) * 2);
        System.out.println(futureNum1.get());
    }

    static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
