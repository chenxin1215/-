package 盛最多水的容器;

import java.math.BigDecimal;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/26
 */
public class Main {

    /**
     * 思路：双指针； 用两个指针指向头尾，算出面积，然后较小的一边往里走
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        int len = height.length;
        int i = 0, j = len - 1;
        while (i < j) {
            int h1 = height[i];
            int h2 = height[j];

            int sum = (j - i) * Math.min(h1, h2);
            if (sum > max) {
                max = sum;
            }

            if (h1 > h2) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int a[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Main().maxArea(a));

    }

}
