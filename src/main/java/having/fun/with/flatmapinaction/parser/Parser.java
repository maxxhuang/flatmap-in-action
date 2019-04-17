package having.fun.with.flatmapinaction.parser;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;
import java.util.function.Function;

import static having.fun.with.flatmapinaction.parser.Parsers.string;
import static having.fun.with.flatmapinaction.parser.Parsers.symbol;


/**
 * Let's pepper the Parser with map/flatMap and make it smell more functional.
 */
public interface Parser<T> {

    ParseResult<T> parse(String source);


    default <U> Parser<U> map(Function<T, U> mapper) {
        return new MapParser<>(this, mapper);
    }

    default <U> Parser<U> flatMap(Function<T, Parser<U>> mapper) {
        return new FlatMapParser<>(this, mapper);
    }

    default <U> Parser<Pair<T, U>> and(Parser<U> next) {
        return flatMap(lv -> next.map(rv -> Pair.of(lv, rv)));
    }

    default Parser<Optional<T>> optional() {
        return map(Optional::ofNullable);
    }


    ///////////////////////////////////////////////////////////////////////////


    public static class ParseResult<T> {

        public static <T> ParseResult<T> success(String remainingSource, T value) {
            return new ParseResult<>(remainingSource, value);
        }

        public static <T> ParseResult<T> failure(String originalSource) {
            return new ParseResult<>(originalSource);
        }


        private String remainingSource;
        private T value;
        private boolean successful;


        private ParseResult(String remainingSource, T value) {
            this.remainingSource = remainingSource;
            this.value = value;
            this.successful = true;
        }

        private ParseResult(String remainingSource) {
            this.remainingSource = remainingSource;
            this.successful = false;
        }

        public String getRemainingSource() {
            return remainingSource;
        }

        public T getValue() {
            return value;
        }

        public boolean isSuccessful() {
            return successful;
        }

        @Override
        public String toString() {
            return "ParseResult{" +
                    "remainingSource='" + remainingSource + '\'' +
                    ", value=" + value +
                    ", successful=" + successful +
                    '}';
        }
    }

}

