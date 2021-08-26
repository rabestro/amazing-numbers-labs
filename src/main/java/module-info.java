module amazing.numbers {
    requires spring.boot;
    requires spring.boot.autoconfigure;

    exports numbers;
    exports numbers.property;
    exports numbers.ui;
    exports numbers.command;
    exports numbers.service;
}