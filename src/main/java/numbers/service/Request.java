package numbers.service;

import java.util.Set;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.Collections.emptySet;
import static java.util.stream.Collectors.toUnmodifiableSet;

public class Request {
    private static final Pattern DELIMITER = Pattern.compile("\\s");

    private final String firstParameter;
    private final String secondParameter;
    private final Set<String> properties;

    public Request(String firstParameter, String secondParameter, Set<String> properties) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.properties = properties;
    }

    public static Request of(String input) {
        var args = DELIMITER.split(input);
        switch (args.length) {
            case 1:
                return new Request(args[0], "", emptySet());
            case 2:
                return new Request(args[0], args[1], emptySet());
            default:
                return new Request(args[0], args[1],
                        stream(args, 2, args.length).collect(toUnmodifiableSet()));
        }
    }

    public String getFirstParameter() {
        return firstParameter;
    }

    public String getSecondParameter() {
        return secondParameter;
    }

    public Set<String> getProperties() {
        return properties;
    }
}
