package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Sunny implements NumberProperty {

    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.add(ONE).sqrtAndRemainder()[1].equals(ZERO);
    }
}
