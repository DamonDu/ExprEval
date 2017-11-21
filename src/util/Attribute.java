package util;

import token.Token;

import java.util.HashMap;

public class Attribute {

    static HashMap<String, int[]> AttributeMap = new HashMap<>() {
        {
            put("DEC", new int[]{26, 25, 1});
            put("BOOL", new int[]{26, 25, 1});
            put("LB", new int[]{0, 25, 0});
            put("RB", new int[]{26, 0, 0});
            put("SIN", new int[]{24, 23, 0});
            put("COS", new int[]{24, 23, 0});
            put("MAX", new int[]{24, 23, 0});
            put("MIN", new int[]{24, 23, 0});
            put("NEG", new int[]{21, 22, 2});
            put("POW", new int[]{19, 20, 2});
            put("MUL", new int[]{18, 17, 3});
            put("DIV", new int[]{18, 17, 3});
            put("ADD", new int[]{16, 15, 3});
            put("SUB", new int[]{16, 15, 3});
            put("EQ", new int[]{14, 13, 3});
            put("GOL", new int[]{14, 13, 3});
            put("LESS", new int[]{14, 13, 3});
            put("LOE", new int[]{14, 13, 3});
            put("GREATER", new int[]{14, 13, 3});
            put("GOE", new int[]{14, 13, 3});
            put("NO", new int[]{11, 12, 2});
            put("AND", new int[]{10, 9, 3});
            put("OR", new int[]{8, 7, 3});
            put("QUE", new int[]{3, 6, 0});
            put("COL", new int[]{5, 4, 5});
            put("COM", new int[]{1, 2, 0});
            put("EOF", new int[]{0, 0, 0});
        }
    };

    static public int priorityF(Token t) {
        return AttributeMap.get(t.getStringValue())[0];
    }

    static public int priorityG(Token t) {
        return AttributeMap.get(t.getStringValue())[1];
    }

    static public int reduceNum(Token t) {
        return AttributeMap.get(t.getStringValue())[2];
    }
}
