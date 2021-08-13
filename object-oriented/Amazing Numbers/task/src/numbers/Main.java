package numbers;

import numbers.property.*;
import numbers.ui.Application;

public class Main {
    public static void main(String[] args) {
        new Application(
                new Properties()
                        .add(new Even())
                        .add(new Odd())
                        .add(new Buzz())
                        .add(new Duck())
                        .add(new Palindromic())
                        .add(new Gapful())
                        .add(new Spy())
                        .add(new Jumping())
                        .add(new Square())
                        .add(new Sunny())
                        .add(new Happy())
                        .add(new Sad())
                        .add("even", "odd")
                        .add("sunny", "square")
                        .add("spy", "duck")
                        .add("happy", "sad")
                        .add("-even", "-odd")
                        .add("-happy", "-sad")
        ).run();
    }

}
