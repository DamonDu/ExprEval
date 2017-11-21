package token;

public class EOF extends Token {

    public EOF() {
        super(Tag.EOF);
    }

    @Override
    public String getStringValue() {
        return "EOF";
    }
}
