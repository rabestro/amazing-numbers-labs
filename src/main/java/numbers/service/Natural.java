package numbers.service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Natural extends BigInteger {
    private final PropertyService propertyService;
    private final Map<String, Boolean> ownProperties = new HashMap<>();

    public Natural(final String val, final PropertyService propertyService) {
        super(val);
        if (this.compareTo(ZERO) < 1) {
            throw new IllegalArgumentException("the natural numbers starts from 1");
        }
        this.propertyService = propertyService;
    }


}
