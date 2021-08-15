package numbers.service;

import numbers.command.Command;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Broker implements Executor {
    private final Set<Command> commandSet;

    public Broker(Collection<Command> commandSet) {
        this.commandSet = new LinkedHashSet<>(commandSet);
    }

    @Override
    public void accept(Request request) {
        commandSet.stream()
                .filter(command -> command.apply(request))
                .findFirst().orElseThrow();
    }
}
