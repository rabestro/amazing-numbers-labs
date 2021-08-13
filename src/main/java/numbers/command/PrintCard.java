package numbers.command;

import numbers.domain.Properties;
import numbers.domain.Request;

import java.math.BigInteger;

public class PrintCard extends AbstractCommand {
    private final Properties properties;

    public PrintCard(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        if (request.length() != 1) {
            return false;
        }
        var number = new BigInteger(request.get(0));
        var tester = properties.getTester(number);
        printf("card.head", number);
        properties.keySet()
                .forEach(property -> printf("card.property", property, tester.test(property)));
        return true;
    }

}
