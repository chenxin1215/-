package 判断子串数量;

import java.util.Scanner;

/**
 * 描述：
 * 给出两个字符串A和B，它们的字母表只包含“o”和“1”。您的任务仅仅是判断A作为B的子字符串出现了多少次?例如，文本字符串B是'1001110110'，而模式字符串A是'11'，
 * 您应该输出3，因为模式A出现在posit中
 * 输入：
 * 第一行只有一个整数N，表示后面有N种情况。在每种情况下，有两行，第一行给出字符串A, length (A) <= 10，第二行给出字符串B, length (B) <= 1000。已知B总是比A长。
 * 输出：
 * 对于每种情况，输出由单个整数组成的单行，表示B作为的子字符串出现了多少次一个。
 *
 * 样例输入
 * 3
 * 11
 * 1001110110
 * 101
 * 110010010010001
 * 1010
 * 110100010101011
 *
 *
 *
 * 样例输出
 * 3
 * 0
 * 3
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String A = sc.next();
            String B = sc.next();
            String t = null;
            int count = 0;
            int size = A.length();
            for (int j = 0; j < B.length();j++) {
                // 剩余的长度小于A的长度 越过 防止数组越界
                if(j+A.length() > B.length()){
                    continue;
                }
                // 从B中取出要比较的串 然后比较
                t = B.substring(j,j+size);
                System.out.println(t);
                if(t.equals(A)){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
