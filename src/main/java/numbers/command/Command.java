package numbers.command;

import numbers.domain.Request;
import numbers.ui.TextInterface;

import java.util.function.Function;

public interface Command extends TextInterface, Function<Request, Boolean> {

}
