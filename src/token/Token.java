package token;

import util.Valueable;

public class Token implements Valueable{

    public enum Tag { EOF, NUM, OP, REV, BOOL}

    final Tag tag;

    protected Token(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public Boolean isEOF() {
        return this.tag == Tag.EOF;
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
    public Operator.OperatorType getOperatorValue() {
        return null;
    }

    @Override
    public Reserved.ReservedType getReservedValue() {
        return null;
    }

    @Override
    public Boolean getBooleanValue() {
        return null;
    }
}

