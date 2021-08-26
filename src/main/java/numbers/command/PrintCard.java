package numbers.command;

import numbers.service.PrinterService;
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
        PrinterService.CARD_PRINTER.accept(naturalNumber);
        return true;
    }

}
