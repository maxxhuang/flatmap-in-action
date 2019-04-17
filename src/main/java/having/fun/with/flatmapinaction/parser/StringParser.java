package having.fun.with.flatmapinaction.parser;

public class StringParser implements Parser<String> {

    @Override
    public ParseResult<String> parse(String source) {
        if (!source.startsWith("\"")) return ParseResult.failure(source);

        String newSource = source.substring(1);
        int index = newSource.indexOf('"');

        if (index == -1) return ParseResult.failure(source);

        String value = newSource.substring(0, index);

        String remainingSource = newSource.length() <= index + 1 ? "" : newSource.substring(index + 1);

        return ParseResult.success(remainingSource, value);
    }
}
