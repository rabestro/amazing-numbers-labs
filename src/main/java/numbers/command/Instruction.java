package numbers.command;

import numbers.domain.Request;

public class Instruction extends AbstractCommand {
    {
        isValid = Request::isEmpty;
        command = () -> printf("instructions");
    }
}
