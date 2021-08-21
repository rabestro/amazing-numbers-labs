package numbers.property;

import java.math.BigInteger;

public class Sad extends AbstractProperty {
    private static final Property HAPPY = new Happy();

    @Override
    public boolean test(BigInteger bigInteger) {
        return HAPPY.negate().test(bigInteger);
    }
}
