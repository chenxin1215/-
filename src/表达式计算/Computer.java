package 表达式计算;

/**
 * <>
 *
 * @Author: chenxin
 * @Date: 2020/3/5
 */

import java.util.Stack;

public class Computer {
    /**
     * 中缀表达式转为后缀表达式 * @param nifixExp * @return
     */
    public static String nifixExpToPostfixExp(String nifixExp) {
        Stack<Character> op = new Stack<>();
        char[] arr = nifixExp.toCharArray();
        int len = arr.length;
        String out = "";
        for (int i = 0; i < len; i++) {
            char ch = arr[i];
            if (ch == ' ')
                continue;
            // if is operand, add to
            // the output stream directly
            if (ch >= '0' && ch <= '9') {
                out += ch;
                continue;
            }
            //if is '(', push to the stack directly
            if (ch == '(')
                op.push(ch);
            //if is '+' or '-', pop the operator
            // from the stack until '(' and add to
            // the output stream
            // push the operator to the stack
            if (ch == '+' || ch == '-') {
                while (!op.empty() && (op.peek() != '(')) {
                    out += op.pop();
                }
                op.push(ch);
                continue;
            }
            //if is '*' or '/', pop the operator stack and add to the output stream until lower priority or '(' push the
            //operator to the stack
            if (ch == '*' || ch == '/') {
                while (!op.empty() && (op.peek() == '*' || op.peek() == '/')) {
                    out += op.pop();
                }
                op.push(ch);
                continue;
            }
            //if is ')' pop the operator stack and add to the output stream until '(', pop '('
            if (ch == ')') {
                while (!op.empty() && op.peek() != '(') {
                    out += op.pop();
                }
                op.pop();
                continue;
            }
        }
        while (!op.empty()) {
            out += op.pop();
        }
        return out;
    }

    /**
     * 计算后缀表达式 * @param postfixExp * @return
     */
    public static int calPostfixExp(String postfixExp) {
        Stack<Integer> v = new Stack<>();
        char[] arr = postfixExp.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            Character ch = arr[i];
            // if is operand, push to the stack
            if (ch >= '0' && ch <= '9')
                v.push(Integer.valueOf(ch - '0'));
                //if is operator, calculate the result with top 2 operands in the stack, push the result into the stack
            else
                v.push(getComputeResult(ch, v.pop(), v.pop()));
        }
        return v.pop();
    }

    /**
     * 计算 * @param op * @param n1 * @param n2 * @return
     */
    public static int getComputeResult(char op, int n1, int n2) {
        if (op == '+')
            return n1 + n2;
        else if (op == '-')
            return n2 - n1;
        else if (op == '*')
            return n2 * n1;
        else if (op == '/')
            return n2 / n1;
        else
            return 0;
    }

    public static void main(String[] args) {
        //注意：操作数大于等于0，小于等于9
        String nifixExp = "1-2+3*(4-5)";
        String postfixExp = nifixExpToPostfixExp(nifixExp);
        System.out.println("中缀表达式：" + nifixExp + "\n" + "后缀表达式：" + postfixExp);
        System.out.println("计算结果：" + calPostfixExp(postfixExp));
    }

}
