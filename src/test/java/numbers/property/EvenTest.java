package numbers.property;

import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Given Buzz property")
class EvenTest {
    private static Random random;

    private Property underTest;

    @BeforeAll
    static void beforeAll() {
        random = new Random();
    }

    @BeforeEach
    void setUp() {
        underTest = new Even();
    }

    @RepeatedTest(10)
    @DisplayName("when test(BigInteger) then it calculate correctly")
    void testEvenProperty() {
        final var number = 1 + random.nextInt(Integer.MAX_VALUE);

        final var expected = (number & 1) == 0;
        final var actual = underTest.test(BigInteger.valueOf(number));

        assertEquals(expected, actual);
    }
}