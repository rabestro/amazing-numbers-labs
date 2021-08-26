package numbers.command;

import numbers.service.PropertyService;
import numbers.service.Request;

public class PrintCard implements Command {
    private final PropertyService propertyService;

    public PrintCard(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @Override
    public Boolean apply(Request request) {
        if (!request.getSecondParameter().isEmpty()) {
            return false;
        }
        final var naturalNumber = propertyService.getNaturalNumber(request.getFirstParameter());
        printf("card.head", naturalNumber);
        propertyService.keySet()
                .forEach(property -> printf("card.property", property, naturalNumber.test(property)));

        return true;
    }

}
