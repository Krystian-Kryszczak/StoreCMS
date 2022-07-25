package app.storecms.model.shopping.basis.price;

public class Price {
    String value;
    String label; // (brutto/netto)
    private Price(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public static Price brutto(String value) {
        return new Price(value, "brutto");
    }
    public static Price netto(String value) {
        return new Price(value, "netto");
    }
}