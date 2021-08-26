package numbers.service;

import numbers.property.Property;

import java.math.BigInteger;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PropertyService {
    public static final char CONTRARY = '-';

    private final Map<String, Property> allProperties;
    private final Set<Set<String>> mutuallyExclusiveSet;

    public PropertyService(Set<Property> allProperties, Set<Set<String>> mutuallyExclusiveSet) {
        this.allProperties = allProperties.stream()
                .collect(Collectors.toUnmodifiableMap(Property::name, Function.identity()));
        this.mutuallyExclusiveSet = mutuallyExclusiveSet;
    }

    public Property get(String name) {
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
