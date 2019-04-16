package having.fun.with.flatmapinaction.stream;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <b>{@code Stream<T>}</b> is a sequence of elements of type (T)
 * <p/>
 * <b>{@code Optional.map(Function<T, U> mapper)}</b> transforms <b>each element</b> in Stream by invoking the mapper function.
 * <p/>
 * If Stream is empty, invoking Stream.map has no effect and this Stream object remains empty.
 */
public class O1_Stream_with_map {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Stream<String> doubleStream1 = stream1.map(s -> s + s);
        System.out.println(doubleStream1.collect(toList())); // [aa, bb, cc]

        Stream<String> stream2 = Stream.of();
        Stream<String> doubleStream2 = stream2.map(s -> s + s);
        System.out.println(doubleStream2.collect(toList())); // []
    }

}
