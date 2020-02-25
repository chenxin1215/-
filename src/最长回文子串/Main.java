package 最长回文子串;

/**
 * 功能描述: <br>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/24
 */

public class Main {

    /**
     * 核心算法：中心扩展算法
     * 思路：遍历字符串，设置i或（i,i+1）为中心（aba，abba），
     * 查看以此为中心 最长的回文串（往左右两边扩散，左右两边相同即为回文）
     */
    public String longestPalindrome(String str) {
        if (str.equals("") || str == null) {
            return str;
        }
        if (str.length() == 1) {
            return str;
        }

        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {

            // 获取i为中心的最大回文长度
            int len1 = fun(str, i, i);
            // 获取（i,i+1）为中心的最大回文长度
            int len2 = fun(str, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                //取两边的下标
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }

        }

        // System.out.println("start = " + start + " end = " + end);
        return str.substring(start, end + 1);
    }

    private int fun(String str, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
            L--;
            R++;
        }
        // 返回元素个数
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Main().longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        //        System.out.println(new Main().longestPalindrome("babacabd"));

    }
}
