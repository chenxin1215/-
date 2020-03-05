package 整数转罗马数字;

/**
 * <整数转罗马数字>
 *
 * @Author: chenxin
 * @Date: 2020/2/26
 */
public class Main {

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }

        String element[] = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Integer elementVal[] = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String romanNum = "";

        int temp = num;
        while (temp > 0) {
            int i = elementVal.length - 1;
            while (i >= 0) {
                Integer val = elementVal[i];
                if (temp >= val) {
                    break;
                }
                i--;
            }
            String romanEle = element[i];
            //            System.out.println("romanEle = " + romanEle);
            romanNum += romanEle;
            temp -= elementVal[i];
        }
        System.out.println("romanNum = " + romanNum);
        return romanNum;

    }

    public static void main(String[] args) {
        new Main().intToRoman(1994);
    }

}
