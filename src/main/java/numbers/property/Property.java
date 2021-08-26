package numbers.property;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public interface Property extends Predicate<Number> {
    Pattern NATURAL_NUMBER = Pattern.compile("[+]?(?!0+$)\\d*\\d");

    static boolean isNaturalNumber(final String value) {
        return NATURAL_NUMBER.matcher(value).matches();
    }

    default String name() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    boolean test(BigInteger number);

    @Override
    default boolean test(Number number) {
        if (number instanceof BigDecimal) {
            final var bigDecimal = (BigDecimal) number;
            return test(bigDecimal.toBigInteger());
        }
        if (number instanceof BigInteger) {
            return test((BigInteger) number);
        }
        return test(number.longValue());
    }

    default boolean test(long number) {
        return test(BigInteger.valueOf(number));
    }

}
