package numbers.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class NaturalNumber extends BigInteger {
    public static final Pattern NATURAL_NUMBER = Pattern.compile("[+]?(?!0+$)\\d*\\d");
    private final PropertyService propertyService;
    private final Map<String, Boolean> properties = new HashMap<>();
    public NaturalNumber(final String val, final PropertyService propertyService) {
        super(val);
        if (this.compareTo(ZERO) < 1) {
            throw new IllegalArgumentException("the natural numbers are positive numbers start from one");
        }
        this.propertyService = propertyService;
    }

    public static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }

    public Set<String> getProperties() {
        return propertyService.keySet().stream().filter(this::test).collect(toUnmodifiableSet());
    }

    public boolean testAll(final Set<QueryParameter> query) {
        return query.stream().allMatch(this::test);
    }

    public boolean test(final String propertyName) {
        return properties.computeIfAbsent(propertyName, key -> propertyService.get(key).test(this));
    }

    public boolean test(final QueryParameter queryParameter) {
        return queryParameter.isOpposite() != test(queryParameter.getPropertyName());
    }

    public NaturalNumber next() {
        return new NaturalNumber(this.add(ONE).toString(), propertyService);
    }
}
