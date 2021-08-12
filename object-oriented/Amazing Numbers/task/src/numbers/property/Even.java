package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class Even implements NumberProperty {

    @Override
    public boolean test(BigInteger number) {
        return number.mod(BigInteger.TWO).equals(ZERO);
    }
}
