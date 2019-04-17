package having.fun.with.flatmapinaction.optional;

import java.util.Optional;

/**
 * Many OO programmers are tempting to treat Optional as a pure data structure.
 * <p/>
 * As it turns out, the code loos no different than that using "null" to represent
 * "value that does not exist".
 * <p/>
 * Many classes introduced in Java 8 are equipped with some functional traits.
 * Let's see how to use them more functionally.
 */
public class O1_Optional_as_pure_data_structure {

    static void codeUsingOptional() {
        Optional<String> optName = Optional.of("...");

        if (optName.isPresent()) {
            System.out.println("I've got something " + optName.get());
        } else {
            System.out.println("Nothing here");
        }
    }

    static void codeUsingNull() {
        String name = "...";

        if (name != null) {
            System.out.println("I've got something " + name);
        } else {
            System.out.println("Nothing here");
        }
    }

}
