package numbers.command;

import numbers.domain.Properties;
import numbers.service.Request;

import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class CheckProperties implements Command {
    private final Properties properties;

    public CheckProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public Boolean apply(Request request) {
        var wrongProperties = request.getProperties()
                .stream()
                .filter(not(properties::hasProperty))
                .collect(Collectors.toUnmodifiableSet());

        if (wrongProperties.isEmpty()) {
            return false;
        }
        var errorMessage = wrongProperties.size() == 1 ? "error.is" : "error.are";
        printf(errorMessage, wrongProperties);
        printf("available", properties);
        return true;
    }
}
