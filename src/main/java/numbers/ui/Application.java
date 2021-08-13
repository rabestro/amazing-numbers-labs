package numbers.ui;

import numbers.domain.Properties;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application implements Runnable, TextInterface {
    private final RequestProcessor processor;

    public Application(Properties properties) {
        this.processor = new RequestProcessor(properties);
    }

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getInput)
                .takeWhile(not("0"::equals))
                .forEach(processor::execute);
    }

    private String getInput() {
        printf("prompt");
        return scanner.nextLine();
    }

}
