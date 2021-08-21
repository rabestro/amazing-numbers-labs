package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class Odd extends AbstractProperty {

    @Override
    public boolean test(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(ONE);
    }

    @Override
    public boolean test(long number) {
        return number % 2 != 0;
    }
}
