package numbers.command;

import numbers.service.Request;

import static numbers.service.Properties.isNatural;

public class CheckFirst implements Command {

    @Override
    public Boolean apply(Request request) {
        if (isNatural(request.getFirstParameter())) {
            return false;
        }
        printf("error.first");
        return true;
    }
}
