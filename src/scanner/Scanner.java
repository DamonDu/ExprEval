package scanner;

import token.*;
import token.Operator.OperatorType;
import token.Token.Tag;

import java.util.ArrayList;

public class Scanner {

    public static ArrayList<Token> scan(String imput) {
        int index = 0;
        int lookahead = 0;
        ArrayList<Token> tokenList = new ArrayList<>();

        while(index < imput.length() && lookahead < imput.length()) {
            Character current = imput.toCharArray()[index];

            if (Character.isSpaceChar(current)) {
                index++;
            }

            else if (Character.isLetter(current)) {
                lookahead = index + 1;
                while (Character.isLetter(imput.toCharArray()[lookahead])) {
                    lookahead++;
                }
                tokenList.add(new Reserved(imput.substring(index, lookahead)));
            }

            else if (Character.isDigit(current)) {
                lookahead = index + 1;
                while (Character.isDigit(imput.toCharArray()[lookahead]) || imput.toCharArray()[lookahead] == '.'
                        || imput.toCharArray()[lookahead] == 'e') {
                    lookahead++;
                }
                tokenList.add(new Num(imput.substring(index, lookahead)));
            }

            else if (Operator.isOperator(current)) {
                if (current == '-') {
                    Token last = tokenList.get(tokenList.size());
                    if (last.getTag() == Tag.NUM)
                        tokenList.add(new Operator(OperatorType.SUB));
                    else if (last.getTag() == Tag.OP) {
                        Operator o = (Operator)last;
                        if (o.getOperatorType() == OperatorType.RB)
                            tokenList.add(new Operator(OperatorType.SUB));
                        else
                            tokenList.add(new Operator(OperatorType.NEG));
                    }
                    else
                        tokenList.add(new Operator(OperatorType.NEG));
                }
                else {
                    lookahead = index + 1;
                    while (Operator.isOperator(imput.toCharArray()[lookahead])) {
                        lookahead++;
                    }
                    tokenList.add(new Operator(imput.substring(index, lookahead)));
                }
            }

            else {
                // TODO: 2017/11/18  exception
                index++;
            }

            if (lookahead > index) {
                index = lookahead;
            }
        }
        return tokenList;
    }
}

