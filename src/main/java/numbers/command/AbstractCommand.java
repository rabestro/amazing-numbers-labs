package numbers.command;

import numbers.domain.Request;

import java.util.function.Predicate;

public abstract class AbstractCommand implements Command {
    protected Predicate<Request> isValid;
    protected Runnable command;

    @Override
    public Boolean apply(Request request) {
        if (isValid.test(request)) {
            command.run();
            return true;
        } else {
            return false;
        }
    }

}
