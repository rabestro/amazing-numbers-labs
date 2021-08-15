package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

public class Square implements Property {

    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.sqrtAndRemainder()[1].equals(ZERO);
    }
}
