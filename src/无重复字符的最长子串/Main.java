package 无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * <给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度>
 *
 * @Author: chenxin
 * @Date: 2020/2/20
 */
public class Main {

    public int lengthOfLongestSubstring(String s) {
        // key：字符， val：字符在s的下标
        Map<Character, Integer> map = new HashMap<>();
        Integer max = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == null) {
                // 不存在则count++ 并把此字符加入map
                count++;
                map.put(c, i);

                if (count > max) {
                    max = count;
                }
            } else {
                // 出现重复字符 count归0
                // 获取此重复字符上一次出现的位置（map中存储的val）赋给i 使循环重新从此字符开始
                // 清空map
                count = 0;
                i = map.get(c);
                map.clear();
            }
        }
        return max;
    }

    /**
     * 思路：遍历字符串 因为我们需要找到字符串中 最长的一个子串
     * 所以：设两个指针i、j 分别指向子串的头和尾 头尾默认为0
     * 遍历时，头不动 尾不断往后走。
     * 当出现重复字符时 将头移动至此字符上一次出现的位置的后一位 尾部继续往后走 这样既能保证我们的要求 也能减少遍历次数
     */
    public int lengthOfLongestSubstringPlus(String s) {
        // key：字符， val：字符在s的下标
        Map<Character, Integer> map = new HashMap<>();
        Integer max = 0;

        // 设i为头 j为尾  i~j表示当前正在处理的字符串
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            Integer index = map.get(c);
            // 更新字符在map中的位置
            map.put(c, j + 1);

            // 如果为新字符 或者 此字符不在i~j的范围中（视为可用字符）更新最大值
            // 如果为重复字符 更新i的位置
            if (index == null || index < i) {
                max = Math.max(max, j - i + 1);
            } else {
                i = index;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int max = new Main().lengthOfLongestSubstring("abcabcbb");
        System.out.println("max = " + max);

        // 优化后：
        int max2 = new Main().lengthOfLongestSubstringPlus("tmmzuxt");
        System.out.println("max2 = " + max2);
        int max3 = new Main().lengthOfLongestSubstringPlus("abcabcbb");
        System.out.println("max3 = " + max3);

    }

}
