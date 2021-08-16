package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface Property extends Predicate<BigInteger> {
    Pattern NATURAL_NUMBER = Pattern.compile("[+]?\\d*\\d");

    default String name() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }
}
