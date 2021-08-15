package numbers.property;

import java.math.BigInteger;

import static java.math.BigInteger.TEN;

public class Jumping implements Property {

    @Override
    public boolean test(BigInteger number) {
        var previous = number.mod(TEN);
        var rest = number.divide(TEN);
        while (!rest.equals(BigInteger.ZERO)) {
            var current = rest.mod(TEN);
            var difference = current.subtract(previous).abs();
            if (!difference.equals(BigInteger.ONE)) {
                return false;
            }
            previous = current;
            rest = rest.divide(TEN);
        }
        return true;
    }
}
