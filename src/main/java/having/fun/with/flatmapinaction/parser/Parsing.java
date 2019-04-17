package having.fun.with.flatmapinaction.parser;

import org.apache.commons.lang3.tuple.Pair;

import static having.fun.with.flatmapinaction.parser.Parsers.string;
import static having.fun.with.flatmapinaction.parser.Parsers.symbol;

public class Parsing {

    public static void main(String[] args) {
        Parser<Pair<String, String>> kvParser = string().and(symbol(":")).map(Pair::getLeft).and(string());

        Parser<?> p = symbol("{").and(kvParser).map(Pair::getRight).and(symbol("}")).map(Pair::getLeft);

        Parser.ParseResult<?> r = p.parse("{\"key1\":\"value1\"}");

        System.out.println(r);
    }
}
