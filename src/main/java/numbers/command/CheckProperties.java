package numbers.command;

import numbers.service.PropertyService;
import numbers.service.Request;

import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

public class CheckProperties implements Command {
    private final PropertyService properties;

    public CheckProperties(PropertyService properties) {
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
