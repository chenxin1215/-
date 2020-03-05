package 回文数;

/**
 * <回文数>
 *
 * @Author: chenxin
 * @Date: 2020/2/26
 */
public class Main {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        }

        int num = 0, t = x;
        while (t > 0) {
            int temp = t % 10;
            num = num * 10 + temp;
            t /= 10;
        }

        if (num == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().isPalindrome(121));
        ;
    }

}
