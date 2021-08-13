package numbers.command;

import numbers.domain.Properties;
import numbers.domain.Request;
import numbers.domain.Tester;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;

public class PrintList extends AbstractCommand {
    private final Properties properties;

    public PrintList(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        if (request.length() < 2) {
            return false;
        }
        var number = new BigInteger(request.get(0));
        var length = Long.parseLong(request.get(1));
        var query = request.getQuery();

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
