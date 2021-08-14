package numbers.ui;

import numbers.service.Executor;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application implements Runnable, TextInterface {
    private final Executor processor;
//    private final Broker broker;

    public Application(Executor executor) {
        this.processor = executor;
    }

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getInput)
                .takeWhile(not("0"::equals))
                .forEach(processor);
    }

    private String getInput() {
        printf("prompt");
        return scanner.nextLine();
    }

}
