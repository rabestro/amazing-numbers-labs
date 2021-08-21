package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class Even extends AbstractProperty {

    @Override
    public boolean test(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(ZERO);
    }

    @Override
    public boolean test(long number) {
        return number % 2 == 0;
    }
}
