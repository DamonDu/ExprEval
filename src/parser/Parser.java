package parser;

import token.EOF;
import token.Token;
import token.Token.Tag;
import util.Attribute;

import java.util.*;

public class Parser {

    static Stack<Object> stack;
    static Queue<Token> queue;

    public static double parse(ArrayList<Token> imput) {
        stack = new Stack<>();
        queue = new LinkedList<>(imput);

        stack.push(new EOF());
        queue.offer(new EOF());

        while (true) {
            Token left;
            Token right = queue.peek();

            if (stack.peek().getClass() != Token.class) {
                Object temp = stack.pop();
                if (stack.peek().getClass() != Token.class) {
                    left = null;
                    // TODO: 2017/11/21
                }
                else {
                    left = (Token) stack.peek();
                }
                stack.push(temp);
            }
            else {
                left = (Token) stack.peek();
            }

            if (left.getTag() == Tag.EOF && right.getTag() == Tag.EOF) {
                if (stack.size() == 2 && stack.peek().getClass() == Double.class) {
                    return (Double)stack.peek();
                }
                else {
                    // TODO: 2017/11/19 ex
                }
            }

            if (Attribute.priorityF(left) > Attribute.priorityG(right)) {
                reduce(left);
            }
            else if (Attribute.priorityF(left) < Attribute.priorityG(right)) {
                shift();
            }
            else {
                // TODO: 2017/11/19 ex
            }
        }
    }

    public static void shift() {
        stack.push(queue.poll());
    }

    public static void reduce(Token left) {
        int reduceNum = Attribute.reduceNum(left);
        if (reduceNum == 0) {

        }
        else {
            Object[] temp = new Object[reduceNum];
            for (int i = 0; i < reduceNum; i++) {
                temp[reduceNum - 1 - i] = stack.pop();
            }
        }
    }

    public static void match(Token left, Object[] tokens) {

    }
}
