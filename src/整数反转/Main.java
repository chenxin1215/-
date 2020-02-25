package 整数反转;

/**
 * <给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。>
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/24
 */
public class Main {

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }

        Long num = 0L;
        int t = Math.abs(x);
        while (t > 0) {
            int ys = t % 10;

            num = num * 10 + ys;

            t /= 10;
        }

        if (num > Integer.MAX_VALUE) {
            return 0;
        }
        if (x < 0) {
            num = -num;
        }
        return num.intValue();
    }

    public static void main(String[] args) {
        System.out.println(new Main().reverse(1111111119));
    }

}
