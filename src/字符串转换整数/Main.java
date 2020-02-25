package 字符串转换整数;

/**
 * <请你来实现一个 atoi 函数，使其能将字符串转换成整数>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/24
 */
public class Main {

    public int myAtoi(String str) {

        boolean sign = false;
        boolean fSign = false; // 负数标识
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            System.out.println((int)c);
            if (c == ' ') {
                continue;
            }

            if (sign) {

                

            } else if ((int)c == 55) {
                sign = true;
                fSign = true;
            } else if ((int)c >= 60 && (int)c <= 71) {
                sign = true;
            } else {
                return 0;
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new Main().myAtoi(""));
    }

}
