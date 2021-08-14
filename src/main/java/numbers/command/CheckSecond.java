package numbers.command;

import numbers.service.Request;

import static numbers.domain.Properties.isNatural;

public class CheckSecond implements Command {

    @Override
    public Boolean apply(Request request) {
        if (isNatural(request.getSecondParameter())) {
            return false;
        }
        printf("error.second");
        return true;
    }
}

