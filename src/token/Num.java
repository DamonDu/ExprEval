package token;

public class Num extends Token {

    double value;

    public Num() { super(Tag.NUM); }

    public Num(double value) {
        super(Tag.NUM);
        this.value = value;
    }

    public Num(String value) {
        super(Tag.NUM);
        if (value.endsWith(".") || value.endsWith("e")) {
            // TODO: 2017/11/18 ex
            return;
        }
        this.value = Double.parseDouble(value);
    }

    @Override
    public double getDoubleValue() {
        return value;
    }
}
