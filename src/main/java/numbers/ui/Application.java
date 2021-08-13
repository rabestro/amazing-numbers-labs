package numbers.ui;

import numbers.Properties;

import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Application extends LocalTextInterface implements Runnable {
    private final RequestProcessor processor;

    public Application(Properties properties) {
        this.processor = new RequestProcessor(properties);
    }

    @Override
    public void run() {
        printf("welcome");
        printf("instructions");

        Stream.generate(this::getRequest)
                .takeWhile(not("0"::equals))
                .forEach(processor::execute);
    }

    private String getRequest() {
        printf("prompt");
        return scanner.nextLine().toLowerCase();
    }

}
