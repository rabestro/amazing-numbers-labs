package numbers;

import numbers.command.*;
import numbers.property.*;
import numbers.service.Broker;
import numbers.service.PropertyService;
import numbers.ui.Application;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Property> properties = Set.of(
                new Even(),
                new Odd(),
                new Buzz(),
                new Duck(),
                new Palindromic(),
                new Gapful(),
                new Spy(),
                new Jumping(),
                new Square(),
                new Sunny(),
                new Happy(),
                new Sad()
        );
        var mutuallyExclusive = Set.of(
                Set.of("even", "odd"),
                Set.of("sunny", "square"),
                Set.of("spy", "duck"),
                Set.of("happy", "sad"),
                Set.of("-even", "-odd"),
                Set.of("-happy", "-sad")
        );
        var propertiesService = new PropertyService(properties, mutuallyExclusive);

        var instructions = List.of(
                new Instruction(),
                new CheckFirst(),
                new PrintCard(propertiesService),
                new CheckSecond(),
                new CheckProperties(propertiesService),
                new CheckMutuallyExclusive(propertiesService),
                new PrintList(propertiesService)
        );

        var executor = new Broker(instructions);

        new Application(executor).run();
    }

}
