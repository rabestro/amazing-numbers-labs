package numbers.command;

import numbers.service.Request;

public class Instruction implements Command {
    @Override
    public Boolean apply(Request request) {
        if (request.getFirstParameter().isEmpty()) {
            printf("instructions");
            return true;
        }
        return false;
    }
}
