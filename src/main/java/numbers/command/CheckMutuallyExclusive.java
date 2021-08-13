package numbers.command;

import numbers.domain.Properties;
import numbers.domain.Request;

import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class CheckMutuallyExclusive extends AbstractCommand {
    private final Properties properties;

    public CheckMutuallyExclusive(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        var mutuallyExclusive = properties.getMutuallyExclusive(request.getQuery());
        if (mutuallyExclusive.isEmpty()) {
            return false;
        }
        printf("error.mutuallyExclusive", mutuallyExclusive);
        return true;
    }
}
