package numbers.property;

import java.math.BigInteger;

public class Sad implements NumberProperty {
    private static final NumberProperty HAPPY = new Happy();

    @Override
    public boolean test(BigInteger bigInteger) {
        return HAPPY.negate().test(bigInteger);
    }
}
