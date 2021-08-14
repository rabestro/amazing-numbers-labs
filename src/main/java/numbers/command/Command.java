package numbers.command;

import numbers.service.Request;
import numbers.ui.TextInterface;

import java.util.function.Function;

public interface Command extends TextInterface, Function<Request, Boolean> {

}
