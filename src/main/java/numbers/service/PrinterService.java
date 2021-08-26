package numbers.service;

import numbers.ui.TextInterface;

import java.util.function.Consumer;

public interface PrinterService extends TextInterface, Consumer<NaturalNumber> {
    PrinterService CARD_PRINTER = new CardPrinter();
    PrinterService LINE_PRINTER = new LinePrinter();
}
