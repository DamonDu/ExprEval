package token;

import java.util.HashMap;
import java.util.Map;

public class Operator extends Token{

    public enum OperatorType { ADD, SUB, MUL, DIV, POW, NEG, QUE, COL, GREATER, LESS, GOE, LOE, EQ, GOL, AND, OR, NO, LB, RB, COM }
    OperatorType value;

    static Map<String, OperatorType> stringMap = new HashMap<>() {
        {
            put("+", OperatorType.ADD);
            put("*", OperatorType.MUL);
            put("/", OperatorType.DIV);
            put("^", OperatorType.POW);
            put("?", OperatorType.QUE);
            put(":", OperatorType.COL);
            put(">", OperatorType.GREATER);
            put("<", OperatorType.LESS);
            put("=", OperatorType.EQ);
            put("&", OperatorType.AND);
            put("|", OperatorType.OR);
            put("!", OperatorType.NO);
            put("(", OperatorType.LB);
            put(")", OperatorType.RB);
            put(">=", OperatorType.GOE);
            put("<=", OperatorType.LOE);
            put("<>", OperatorType.GOL);
            put(",", OperatorType.COM);
        }
    };

    static public Boolean isOperator(Character c) {
        return (stringMap.containsKey(c.toString()) || c == '-');
    }

    public Operator() {
        super(Tag.OP);
    }

    public Operator(OperatorType type) {
        super(Tag.OP);
        this.value = type;
    }

    public Operator(String s) {
        super(Tag.OP);
        if (stringMap.containsKey(s)) {
            this.value = stringMap.get(s);
        }
        else {
            // TODO: 2017/11/18 ex
        }
    }

    @Override
    public OperatorType getOperatorValue() {
        return this.value;
    }

    @Override
    public String getStringValue() {
        return this.value.toString();
    }
}
