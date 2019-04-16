package having.fun.with.flatmapinaction.stream;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <b>{@code Stream.flatMap(Function<T, Stream<U>>)}</b> combines 2 <b>Stream</b> objects.
 * <p/>
 * {@code
 *     stream2 = stream1.flatMap(v1 -> // create stream2)
 * }
 * <p/>
 * If stream1 has n elements, the mapper function <b>{@code Function<T, Stream<U>}</b> would be invoked n times.
 * <p/>
 * The mapper function {@code Function<T, Stream<U>} has the access to the value of the element in stream1.
 * With this value (T) you can decide how and what to generate stream2 {@code (Stream<U>)} in the mapper function.
 * <p/>
 * As stream1 has n elements, there'd be n stream2(s) generated via the mapper function.
 * Stream.flatMap concatenates generated sub-streams from the mapper function.
 * The end result of Stream.flatMap is a joint stream containing every elements from every stream2.
 */
public class O2_Stream_with_flatMap {

    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 2, 3);
        Stream<String> alphabetStream1 = stream1.flatMap(n -> nAlphabets(n).stream());
        System.out.println(alphabetStream1.collect(toList())); // [A, B, B, C, C, C]

        Stream<Integer> stream2 = Stream.of();
        Stream<String> alphabetStream2 = stream2.flatMap(n -> nAlphabets(n).stream());
        System.out.println(alphabetStream2.collect(toList())); // []
    }

    static List<String> nAlphabets(int n) {
        int c = 'A' + (n - 1);

        List<String> alphabets = Collections.nCopies(n, String.valueOf((char) c));

        System.out.println("Generated alphabet list: " + alphabets);

        return alphabets;
    }

}
