package numbers.property;

import java.math.BigInteger;

public class Duck implements Property {

    @Override
    public boolean test(BigInteger bigInteger) {
        return bigInteger.toString().indexOf('0') > -1;
    }
}
