package numbers.command;

import numbers.service.Request;

import static numbers.property.Property.isNaturalNumber;

public class CheckFirst implements Command {

    @Override
    public Boolean apply(Request request) {
        if (isNaturalNumber(request.getFirstParameter())) {
            return false;
        }
        printf("error.first");
        return true;
    }
}
