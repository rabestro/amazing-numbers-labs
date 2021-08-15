package numbers.property;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given Jumping property")
class JumpingTest {
    private Property underTest;

    @BeforeEach
    void setUp() {
        underTest = new Jumping();
    }

    @DisplayName("given test() method")
    @ParameterizedTest(name = "when number is \"{0}\" then \"{1}\"")
    @CsvFileSource(resources = "/property/jumping.csv", numLinesToSkip = 1)
    void buzzProperty(final BigInteger number, final boolean expected) {
        assertEquals(expected, underTest.test(number));
    }
}