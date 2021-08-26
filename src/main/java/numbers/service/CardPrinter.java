package numbers.service;

public class CardPrinter implements PrinterService {

    @Override
    public void accept(final NaturalNumber naturalNumber) {
        printf("card.header", naturalNumber);
        naturalNumber.getProperties().forEach(this::printProperty);
    }

    private void printProperty(final String name, final Boolean value) {
        printf("card.property", name, value);
    }
}
