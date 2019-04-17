package having.fun.with.flatmapinaction.parser;

import java.util.function.Function;

public class FlatMapParser<T, U> implements Parser<U> {

    private Parser<T> delegate;

    private Function<T, Parser<U>> mapper;

    public FlatMapParser(Parser<T> delegate, Function<T, Parser<U>> mapper) {
        this.delegate = delegate;
        this.mapper = mapper;
    }

    @Override
    public ParseResult<U> parse(String source) {
        ParseResult<T> result = this.delegate.parse(source);

        if (!result.isSuccessful()) return ParseResult.failure(source);

        Parser<U> nextParser = this.mapper.apply(result.getValue());

        return nextParser.parse(result.getRemainingSource());
    }
}
