package numbers.command;

import numbers.service.Properties;
import numbers.service.Request;

public class CheckMutuallyExclusive implements Command {
    private final Properties properties;

    public CheckMutuallyExclusive(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        var mutuallyExclusive = properties
                .getMutuallyExclusive(request.getProperties());
        if (mutuallyExclusive.isEmpty()) {
            return false;
        }
        printf("error.mutuallyExclusive", mutuallyExclusive);
        return true;
    }
}
