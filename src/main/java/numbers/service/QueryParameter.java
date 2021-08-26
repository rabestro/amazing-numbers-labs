package numbers.service;

public class QueryParameter {
    private final String parameter;
    private final boolean isOpposite;
    private final String propertyName;

    public QueryParameter(final String parameter) {
        this.parameter = parameter;
        this.isOpposite = parameter.length() > 0 && parameter.charAt(0) == '-';
        this.propertyName = isOpposite ? parameter.substring(1) : parameter;
    }

    public String getParameter() {
        return parameter;
    }

    public boolean isOpposite() {
        return isOpposite;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
