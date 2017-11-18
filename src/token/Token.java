package token;

import util.Valueable;

public class Token implements Valueable{

    public enum Tag { EOF, NUM, OP, REV}

    final Tag tag;

    protected Token(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public double getDoubleValue() {
        return Double.NaN;
    }

    @Override
    public String getStringValue() {
        return null;
    }

    @Override
    public Operator.OperatorType getOperatorType() {
        return null;
    }

    @Override
    public Reserved.ReservedType getReservedType() {
        return null;
    }
}

