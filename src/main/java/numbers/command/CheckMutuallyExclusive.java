package numbers.command;

import numbers.service.PropertyService;
import numbers.service.Request;

public final class CheckMutuallyExclusive implements Command {
    private final PropertyService properties;

    public CheckMutuallyExclusive(final PropertyService properties) {
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
