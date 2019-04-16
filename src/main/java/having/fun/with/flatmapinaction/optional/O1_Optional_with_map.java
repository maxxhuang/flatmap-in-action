package having.fun.with.flatmapinaction.optional;

import java.util.Optional;

/**
 * <b>{@code Optional<T>}</b> is a holder containing possibly existing value.
 * <p/>
 * <b>{@code Optional.map(Function<T, U> mapper)}</b> transforms the <b>the may-or-may-not-exist value</b> inside Optional by invoking the mapper function.
 * <p/>
 * If Optional is empty, invoking Optional.map has no effect and this Optional object remains empty.
 */
public class O1_Optional_with_map {

    public static void main(String[] args) {
        Optional<String> optStr1 = Optional.of("123");
        Optional<Integer> optNum1 = optStr1.map(str -> Integer.parseInt(str) * 2);
        System.out.println(optNum1); // Optional[246]

        Optional<String> optStr2 = Optional.empty();
        Optional<Integer> optNum2 = optStr2.map(str -> Integer.parseInt(str) * 2);
        System.out.println(optNum2); // Optional.empty
    }

}
