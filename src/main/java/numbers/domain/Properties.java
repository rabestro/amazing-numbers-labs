package numbers.domain;

import numbers.property.NumberProperty;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Properties {
    public static final char CONTRARY = '-';
    public static final Pattern NATURAL = Pattern.compile("[+]?\\d*\\d");

    private final Map<String, NumberProperty> allProperties;
    private final Set<Set<String>> mutuallyExclusiveSet;

    public Properties() {
        allProperties = new HashMap<>();
        mutuallyExclusiveSet = new HashSet<>();
    }

    public static boolean isNotNatural(final String value) {
        return !NATURAL.matcher(value).matches();
    }

    public Properties put(NumberProperty property) {
        allProperties.put(property.name(), property);
        mutuallyExclusiveSet.add(Set.of(property.name(), CONTRARY + property.name()));
        return this;
    }

    public Properties add(String... mutuallyExclusive) {
        mutuallyExclusiveSet.add(Set.of(mutuallyExclusive));
        return this;
    }

    public NumberProperty get(String name) {
        return allProperties.get(name);
    }

    public boolean hasProperty(String name) {
        return isContraryProperty(name)
                ? allProperties.containsKey(name.substring(1))
                : allProperties.containsKey(name);
    }

    public Tester getTester(BigInteger number) {
        return new Tester(this, number);
    }

    public boolean isContraryProperty(String name) {
        return name.length() > 0 && name.charAt(0) == CONTRARY;
    }

    public Set<Set<String>> getMutuallyExclusive(Set<String> properties) {
        return mutuallyExclusiveSet.stream()
                .filter(properties::containsAll)
                .collect(Collectors.toUnmodifiableSet());
    }

    public Set<String> keySet() {
        return allProperties.keySet();
    }

    @Override
    public String toString() {
        return allProperties.keySet().toString();
    }

}
