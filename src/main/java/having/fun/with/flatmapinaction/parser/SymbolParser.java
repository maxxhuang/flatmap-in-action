package having.fun.with.flatmapinaction.parser;

public class SymbolParser implements Parser<String> {

    private String symbol;

    public SymbolParser(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public ParseResult<String> parse(String source) {
        if (source.startsWith(symbol)) {
            String remainingSource = source.length() > symbol.length() ? source.substring(symbol.length()) : "";
            return ParseResult.success(remainingSource, this.symbol);
        }

        return ParseResult.failure(source);
    }
}
