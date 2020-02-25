package Z字形变换;

/**
 * <将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列>
 * <p>
 * 例1：
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * <p>
 * 例2：
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/24
 */
public class Main {

    public String convert(String s, int numRows) {
        if (s == null || s.equals("")) {
            return "";
        }

        int len = s.length();
        if (numRows == 1 || numRows >= len) {
            return s;
        }

        char a[][] = new char[numRows][len];
        int b[][] = new int[numRows][len];
        // xSign为true时表示x轴++ 反之x轴-- ；ySign为true时 表示y轴不动 反之y轴++
        boolean xSign = false, ySign = false;
        for (int i = 0, x = 0, y = 0; i < len; i++) {

            a[x][y] = s.charAt(i);
            b[x][y] = 1;

            if (x == 0) {
                xSign = true;
                ySign = true;
            } else if (x == numRows - 1) {
                xSign = false;
                ySign = false;
            }

            if (xSign) {
                x++;
            } else {
                x--;
            }
            if (!ySign) {
                y++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len; j++) {
                if (b[i][j] == 1) {
                    // System.out.print(a[i][j]);
                    sb.append(a[i][j]);
                }
            }
            // System.out.println();
        }
        String s1 = sb.toString().trim();
        return s1;
    }

    public static void main(String[] args) {
        String s = new Main().convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }

}
