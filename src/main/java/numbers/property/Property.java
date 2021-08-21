package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface Property extends Predicate<Number> {
    Pattern NATURAL_NUMBER = Pattern.compile("[+]?\\d*\\d");

    static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }

    default String name() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    boolean test(BigInteger number);

    @Override
    default boolean test(Number number) {
        return number instanceof BigInteger
                ? test((BigInteger) number)
                : test(number.longValue());
    }

    default boolean test(long number) {
        return test(BigInteger.valueOf(number));
    }

}
