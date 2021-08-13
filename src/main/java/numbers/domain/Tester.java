package numbers.domain;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toUnmodifiableSet;

public class Tester implements Predicate<String> {
    private final Properties properties;
    private final BigInteger number;
    private final Map<String, Boolean> ownProperties;

    Tester(Properties properties, BigInteger number) {
        this.properties = properties;
        this.number = number;
        ownProperties = new HashMap<>();
    }

    public Set<String> getProperties() {
        return properties.keySet().stream().filter(this).collect(toUnmodifiableSet());
    }

    public BigInteger getNumber() {
        return number;
    }

    public boolean testAll(Set<String> properties) {
        return properties.stream().allMatch(this);
    }

    @Override
    public boolean test(String name) {
        var isContrary = properties.isContraryProperty(name);
        var property = isContrary ? name.substring(1) : name;
        var isPresent = ownProperties.computeIfAbsent(property,
                key -> properties.get(key).test(number));
        return isContrary != isPresent;
    }
}
