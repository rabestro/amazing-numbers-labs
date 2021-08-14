package numbers.service;

import numbers.command.Command;
import numbers.domain.Properties;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Broker implements Executor {
    private final Properties properties;
    private final Set<Command> commandSet;

    public Broker(Properties properties, Collection<Command> commandSet) {
        this.properties = properties;
        this.commandSet = new LinkedHashSet<>(commandSet);
    }

    @Override
    public void accept(String input) {
        var request = Request.of(input);
        commandSet.stream()
                .filter(command -> command.apply(request))
                .findFirst().orElseThrow();
    }
}
