package 四则运算;

import java.util.Random;

/**
 * <随机数工具>
 *
 * @Author: chenxin
 * @Date: 2020/3/5
 */
public class RandomUtil {

    /**
     * 获取随机数
     */
    public static int getRandomNum(int start, int end) {
        Random rd = new Random();
        int num = start + rd.nextInt(end - start);
        return num;
    }

    /**
     * 随机获取运算符
     */
    public static Character getEquationChar() {
        Random rd = new Random();
        Character c;
        int num = 1 + rd.nextInt(4);
        if (num == 1) {
            c = '+';
        } else if (num == 2) {
            c = '-';
        } else if (num == 3) {
            c = '*';
        } else {
            c = '/';
        }
        return c;
    }

}
