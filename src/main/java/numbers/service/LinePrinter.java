package numbers.service;

import java.util.Map;
import java.util.stream.Collectors;

public class LinePrinter implements PrinterService {
    @Override
    public void accept(final NaturalNumber naturalNumber) {
        final var properties = naturalNumber
                .getProperties()
                .entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));

        printf("line.properties", naturalNumber, properties);
    }
}
