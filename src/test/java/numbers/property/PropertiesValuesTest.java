package numbers.property;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

@DisplayName("Given Number Property")
class PropertiesValuesTest {
    @ParameterizedTest(name = "Given `{0}` when {1} then {2}")
    @ArgumentsSource(PropsNumbers.class)
    void testProperty(Property underTest, Number number, boolean expected) {
        assertEquals(expected, underTest.test(number));
    }

    static class PropsNumbers implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    of(new Jumping(), 123, true),
                    of(new Jumping(), 200, false),
                    of(new Jumping(), 53141, false),
                    of(new Jumping(), 5434567L, true),
                    of(new Jumping(), valueOf(31511), false),
                    of(new Even(), 1, false),
                    of(new Even(), 2, true),
                    of(new Even(), 1515463, false),
                    of(new Even(), 5367245, false),
                    of(new Even(), 75193850, true),
                    of(new Odd(), 1, true),
                    of(new Odd(), 2, false),
                    of(new Odd(), 34325522, false),
                    of(new Odd(), 134141, true),
                    of(new Buzz(), 1, false),
                    of(new Buzz(), 7, true),
                    of(new Buzz(), 14, true),
                    of(new Buzz(), 13, false),
                    of(new Buzz(), valueOf(3532547L), true),
                    of(new Duck(), valueOf(51353245154303421L), true),
                    of(new Duck(), 3532547, false),
                    of(new Duck(), valueOf(35364185632547L), false),
                    of(new Duck(), valueOf(34520532547L), true),
                    of(new Gapful(), 1, false),
                    of(new Gapful(), 7, false),
                    of(new Gapful(), 14, false),
                    of(new Gapful(), 100, true)
            );
        }
    }
}
