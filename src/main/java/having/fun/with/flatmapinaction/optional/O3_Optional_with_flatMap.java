package having.fun.with.flatmapinaction.optional;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <b>{@code Optional.flatMap(Function<T, Optional<U>>)}</b> combines 2 <b>Optional</b> objects.
 * <p/>
 * {@code
 *     optional2 = optional.flatMap(v1 -> // create optional2)
 * }
 * <p/>
 * The mapper function {@code Function<T, Optional< U >} has the access to the value of optional1.
 * With this value (T) you can decide how and what to generate optional2 {@code (Optional<U>)}. in the mapper function.
 */
public class O3_Optional_with_flatMap {

    public static void main(String[] args) {

        Optional<Integer> optNum1 = Optional.of(3);
        Optional<String> starOrHash1 = optNum1.flatMap(n -> maybeStarHash(n));
        System.out.println(starOrHash1); // Optional[***]

        Optional<Integer> optNum2 = Optional.of(-3);
        Optional<String> starOrHash2 = optNum2.flatMap(n -> maybeStarHash(n));
        System.out.println(starOrHash2); // Optional[###]

        Optional<Integer> optNum3 = Optional.of(0);
        Optional<String> starOrHash3 = optNum3.flatMap(n -> maybeStarHash(n));
        System.out.println(starOrHash3); // Optional.empty

    }

    static Optional<String> maybeStarHash(int n) {
        if (n == 0) return Optional.empty();
        return Optional.of(starHash(n));
    }

    static String starHash(int num) {
        String symbol = num > 0 ? "*" : "#";
        return Collections.nCopies(Math.abs(num), symbol).stream()
                .collect(Collectors.joining());
    }

}
