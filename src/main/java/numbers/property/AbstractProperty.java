package numbers.property;

public abstract class AbstractProperty implements Property {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
