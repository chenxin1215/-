package 表达式计算;
/**
 * 问题描述
 * 　　输入一个只包含加减乖除和括号的合法表达式，求表达式的值。其中除表示整除。
 * 输入格式
 * 　　输入一行，包含一个表达式。
 * 输出格式
 * 　　输出这个表达式的值。
 * 样例输入
 * 1-2+3*(4-5)
 * 样例输出
 * -4
 * 数据规模和约定
 * 　　表达式长度不超过100，表达式运算合法且运算过程都在int内进行。
 */

import java.util.Scanner;

public class Main {

    public static String source[] = new String[100];

    public double count(int start, int end){
        double sum = 0;



        return 0;
    }

    public static boolean isOpera(String c){
        if(c.equals("+") || c.equals("-") || c.equals("*")|| c.equals("/")){
            return  true;
        }else{
            return  false;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int t = 0;
        String a = "";
        for (int i = 0; i < s.length(); i++) {
            String now = String.valueOf(s.charAt(i));
            if(isOpera(now)){
                source[t++] = a;
                source[t++] = now;
                a = "";
            }else if(now.equals("(") || now.equals(")")){
                if(!a.equals("")){
                    source[t++] = a;
                }
                source[t++] = now;
            }else{
                a += now;
                if(i == s.length()-1){
                    source[t++] = a;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.print(source[i]+"\t");
        }

//        new Main().count(source);
    }
}
