package numbers.command;

import numbers.service.PropertyService;
import numbers.service.Request;

import java.math.BigInteger;

public class PrintCard implements Command {
    private final PropertyService properties;

    public PrintCard(PropertyService properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        if (!request.getSecondParameter().isEmpty()) {
            return false;
        }
        var number = new BigInteger(request.getFirstParameter());
        var tester = properties.getTester(number);
        printf("card.head", number);
        properties.keySet()
                .forEach(property -> printf("card.property", property, tester.test(property)));
        return true;
    }

}
