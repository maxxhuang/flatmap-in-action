package having.fun.with.flatmapinaction.future;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunFuture<T> {

    public static <T> FunFuture<T> supplyAsync(Supplier<T> supplier) {
        return new FunFuture<>(
                CompletableFuture.supplyAsync(supplier)
        );
    }


    private CompletableFuture<T> completableFuture;

    private FunFuture(CompletableFuture<T> completableFuture) {
        this.completableFuture = completableFuture;
    }

    private <U> FunFuture<U> map(Function<T,U> mapper) {
        return new FunFuture<>(this.completableFuture.thenApply(mapper));
    }

    public <U> FunFuture<U> flatMap(Function<T, FunFuture<U>> mapper) {
        CompletableFuture<U> newFuture =
                this.completableFuture.thenCompose(v -> mapper.apply(v).getRealFuture());

        return new FunFuture<>(newFuture);
    }

    public void doWhenComplete(Consumer<T> action) {
        this.completableFuture.thenAccept(action);
    }

    private CompletableFuture<T> getRealFuture() {
        return this.completableFuture;
    }

}
