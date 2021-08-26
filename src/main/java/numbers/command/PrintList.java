package numbers.command;

import numbers.service.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintList implements Command {
    private final PropertyService properties;

    public PrintList(PropertyService properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        if (request.getSecondParameter().isEmpty()) {
            return false;
        }
        var naturalNumber = properties.getNaturalNumber(request.getFirstParameter());
        var length = Long.parseLong(request.getSecondParameter());
        var query = request.getProperties().stream()
                .map(QueryParameter::new)
                .collect(Collectors.toUnmodifiableSet());

        Stream.iterate(naturalNumber, NaturalNumber::next)
                .filter(n -> n.testAll(query))
                .limit(length)
                .forEach(PrinterService.LINE_PRINTER);

        return true;
    }

}
