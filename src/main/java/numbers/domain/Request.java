package numbers.domain;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Request {
    private static final Pattern SPACE = Pattern.compile("\\s");

    private final String[] arguments;

    public Request(String input) {
        arguments = SPACE.split(input.toLowerCase());
    }

    public boolean isEmpty() {
        return arguments[0].isEmpty();
    }

    public String get(int index) {
        return arguments[index];
    }

    public int length() {
        return arguments.length;
    }

    public Set<String> getQuery() {
        return stream(arguments, 2, arguments.length)
                .collect(Collectors.toUnmodifiableSet());
    }
}
