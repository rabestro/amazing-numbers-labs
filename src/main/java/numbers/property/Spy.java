package numbers.property;

import java.math.BigInteger;

public class Spy implements NumberProperty {

    @Override
    public boolean test(BigInteger number) {
        var product = number.toString().chars().map(Character::getNumericValue).reduce(1, (a, b) -> a * b);
        return product > 0 && product == number.toString().chars().map(Character::getNumericValue).sum();
    }
}
