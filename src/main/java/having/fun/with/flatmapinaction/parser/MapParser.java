package having.fun.with.flatmapinaction.parser;

import java.util.function.Function;

public class MapParser<T, U> implements Parser<U> {

    private Parser<T> delegate;

    private Function<T, U> mapper;

    public MapParser(Parser<T> delegate, Function<T, U> mapper) {
        this.delegate = delegate;
        this.mapper = mapper;
    }

    @Override
    public ParseResult<U> parse(String source) {
        ParseResult<T> result = this.delegate.parse(source);

        if (!result.isSuccessful()) return ParseResult.failure(source);

        return ParseResult.success(result.getRemainingSource(), this.mapper.apply(result.getValue()));
    }
}
