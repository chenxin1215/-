package 寻找两个有序数组的中位数;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    /**
     * 思路：使用两个指针同时遍历两个数组
     * 依次将小的存到新数组c 小的一方往后走 大的不动 如果有一方走完了 结束循环
     * 将未走完的一方的数据加到c数组后面即完成了所有数据的排序 然后取中位数即可
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] c = new int[nums1.length + nums2.length];
        if (c.length == 0) {
            return 0;
        }
        double sum = 0;
        int i = 0, j = 0, t = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                c[t++] = nums1[i];
                i++;
            } else if (nums1[i] == nums2[j]) {
                c[t++] = nums1[i];
                i++;
                c[t++] = nums2[j];
                j++;
            } else {
                c[t++] = nums2[j];
                j++;
            }
        }
        for (int k = i; k < nums1.length; k++) {
            c[t++] = nums1[k];
        }
        for (int k = j; k < nums2.length; k++) {
            c[t++] = nums2[k];
        }

        if (t % 2 == 0) {
            int v = t / 2 - 1;
            sum = (double)(c[v] + c[v + 1]) / 2.0;
        } else {
            int v = t / 2;
            sum = (double)c[v];
        }
        return sum;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double sum = 0;

        if (nums1[0] > nums2[0]) {
            for (int i = nums2.length - 1; i >= 0; i--) {
                if (nums1[0] > nums2[i]) {

                }
            }
        } else {

        }

        return sum;
    }

    public static void main(String[] args) {
        int a[] = {1, 3};
        int b[] = {2};
        double v = new Solution().findMedianSortedArrays(a, b);
        System.out.println(v);
    }
}
