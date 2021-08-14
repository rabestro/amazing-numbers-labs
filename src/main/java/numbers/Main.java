package numbers;

import numbers.command.*;
import numbers.domain.Properties;
import numbers.property.*;
import numbers.service.Broker;
import numbers.ui.Application;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var numberProperties = new Properties()
                .put(new Even())
                .put(new Odd())
                .put(new Buzz())
                .put(new Duck())
                .put(new Palindromic())
                .put(new Gapful())
                .put(new Spy())
                .put(new Jumping())
                .put(new Square())
                .put(new Sunny())
                .put(new Happy())
                .put(new Sad())
                .add("even", "odd")
                .add("sunny", "square")
                .add("spy", "duck")
                .add("happy", "sad")
                .add("-even", "-odd")
                .add("-happy", "-sad");

        var executor = new Broker(numberProperties, List.of(
                new Instruction(),
                new CheckFirst(),
                new PrintCard(numberProperties),
                new CheckSecond(),
                new CheckProperties(numberProperties),
                new CheckMutuallyExclusive(numberProperties),
                new PrintList(numberProperties)
        ));

        new Application(executor).run();
    }

}
