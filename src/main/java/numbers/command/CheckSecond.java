package numbers.command;

import numbers.service.Request;

import static numbers.property.Property.isNaturalNumber;

public class CheckSecond implements Command {

    @Override
    public Boolean apply(Request request) {
        if (isNaturalNumber(request.getSecondParameter())) {
            return false;
        }
        printf("error.second");
        return true;
    }
}

