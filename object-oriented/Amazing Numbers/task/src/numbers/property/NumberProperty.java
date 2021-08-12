package numbers.property;

import java.math.BigInteger;
import java.util.function.Predicate;

public interface NumberProperty extends Predicate<BigInteger> {
    String name();

}
