package numbers.command;

import numbers.domain.Properties;
import numbers.domain.Tester;
import numbers.service.Request;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class PrintList implements Command {
    private final Properties properties;

    public PrintList(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        if (request.getSecondParameter().isEmpty()) {
            return false;
        }
        var number = new BigInteger(request.getFirstParameter());
        var length = Long.parseLong(request.getSecondParameter());
        var query = request.getProperties();

        Stream.iterate(number, ONE::add)
                .map(properties::getTester)
                .filter(tester -> tester.testAll(query))
                .limit(length)
                .forEach(this::printList);

        return true;
    }

    private void printList(Tester tester) {
        printf("line.properties",
                tester.getNumber(),
                String.join(", ", tester.getProperties()));
    }
}
