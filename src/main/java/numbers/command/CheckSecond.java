package numbers.command;

import static numbers.domain.Properties.isNotNatural;

public class CheckSecond extends AbstractCommand {
    {
        isValid = request -> isNotNatural(request.get(1));
        command = () -> printf("error.second");
    }
}
