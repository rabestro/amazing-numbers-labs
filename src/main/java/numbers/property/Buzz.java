package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class Buzz implements Property {
    private static final BigInteger SEVEN = BigInteger.valueOf(7);

    @Override
    public boolean test(BigInteger number) {
        return number.mod(TEN).equals(SEVEN) || number.mod(SEVEN).equals(ZERO);
    }
}
