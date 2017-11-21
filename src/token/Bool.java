package token;

public class Bool extends Token {

    Boolean value;

    public Bool() {
        super(Tag.BOOL);
    }

    public Bool(String s) {
        super(Tag.BOOL);
        this.value = toBoolean(s);
    }

    static public Boolean toBoolean(String s) {
        if ("true".equals(s))
            return true;
        else if ("false".equals(s))
            return false;
        else
            return null;
    }

    @Override
    public Boolean getBooleanValue() {
        return this.value;
    }

    @Override
    public String getStringValue() {
        return "BOOL";
    }

}
