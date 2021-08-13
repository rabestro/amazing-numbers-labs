package numbers.command;

import static numbers.domain.Properties.isNotNatural;

public class CheckFirst extends AbstractCommand {
    {
        isValid = request -> isNotNatural(request.get(0));
        command = () -> printf("error.first");
    }
}
