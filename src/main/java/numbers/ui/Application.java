package numbers.ui;

import numbers.service.Executor;
import numbers.service.Request;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application implements Runnable, TextInterface {
    private static final String EXIT = "0";
    private final Executor executor;

    public Application(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getInput)
                .takeWhile(not(EXIT::equals))
                .map(Request::new)
                .forEach(executor);
    }

    private String getInput() {
        printf("prompt");
        return scanner.nextLine();
    }

}
