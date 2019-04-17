package having.fun.with.flatmapinaction.parser;

abstract public class Parsers {

    public static StringParser string() {
        return new StringParser();
    }

    public static SymbolParser symbol(String symbol) {
        return new SymbolParser(symbol);
    }

}
