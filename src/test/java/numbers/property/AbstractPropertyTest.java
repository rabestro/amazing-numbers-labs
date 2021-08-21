package numbers.property;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class AbstractPropertyTest {
    static final String CSV = "/property/buzz.csv";

    private final Property underTest;

    public AbstractPropertyTest(Property property) {
        this.underTest = property;
    }

    @DisplayName("given test() method")
    @ParameterizedTest(name = "when number is \"{0}\" then \"{1}\"")
    @CsvFileSource(resources = CSV, numLinesToSkip = 1)
    void testProperty(final BigInteger number, final boolean expected) {
        assertEquals(expected, underTest.test(number));
    }
}
