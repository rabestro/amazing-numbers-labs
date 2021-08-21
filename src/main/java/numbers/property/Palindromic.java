package numbers.property;

import java.math.BigInteger;

public class Palindromic extends AbstractProperty {

    @Override
    public boolean test(BigInteger number) {
        return new StringBuilder(number.toString())
                .reverse().toString().equals(number.toString());
    }
}
