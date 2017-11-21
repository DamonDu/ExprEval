package token;

import java.util.HashMap;
import java.util.Map;

public class Reserved extends Token {

    public enum ReservedType { SIN, COS, MAX, MIN}
    ReservedType value;

    static Map<String, ReservedType> stringMap = new HashMap<>() {
        {
            put("sin", ReservedType.SIN);
            put("cos", ReservedType.COS);
            put("max", ReservedType.MAX);
            put("min", ReservedType.MIN);
        }
    };

    public Reserved() {
        super(Tag.REV);
    }

    public Reserved(String s) {
        super(Tag.REV);
        if (stringMap.containsKey(s)){
            this.value = stringMap.get(s);
        }
        else {
            // TODO: 2017/11/18 ex
        }
    }

    @Override
    public ReservedType getReservedValue() {
        return this.value;
    }

    @Override
    public String getStringValue() {
        return this.value.toString();
    }
}



