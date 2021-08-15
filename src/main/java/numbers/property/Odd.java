package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

public class Odd implements Property {

    @Override
    public boolean test(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(ONE);
    }
}
