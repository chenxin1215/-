package N数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 题解思路：
 * 首先对数组判空，然后对数组进行排序；我们的解法是：先固定一个数，然后去找另外两个数
 * 所以：便利数组，设固定的数为nums[i]，令L = i+1， R = len-1
 * 然后判断nums[i] + nums[L] + nums[R] == 0
 * 若满足：使L++ R--， 这里要进行 去重判断，当下一个数与之前的数相同 跳过
 * 不满足：如果sum > 0 说明数据过大 则R--， 当sum < 0 说明数据过小 则L++
 * <p>
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2020/2/20
 */
public class Main {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        int length = nums.length;
        Arrays.sort(nums);
        int L, R;
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                // 如果最小的数大于0 则sum肯定不为0 结束循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 重复数据 跳过
                continue;
            }
            L = i + 1;
            R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 跳过重复数据
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    while (L < R && nums[R] == nums[R - 1])
                        R--;

                    // L、R 都走一步
                    L++;
                    R--;
                } else {
                    // 数据过大 则R-- 过小则L++
                    if (sum > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }
        int length = nums.length;
        Arrays.sort(nums);
        int L, R;
        // length - 3 预留三个位置给后面的数
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                L = j + 1;
                R = length - 1;

                while (L < R) {
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        // 跳过重复数据
                        while (L < R && nums[L] == nums[L + 1])
                            L++;
                        while (L < R && nums[R] == nums[R - 1])
                            R--;

                        // L、R 都走一步
                        L++;
                        R--;
                    } else {
                        // 数据过大 则R-- 过小则L++
                        if (sum > target) {
                            R--;
                        } else {
                            L++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        int nums[] = {-1, 0, 1, 2, -1, -4};
        //        //        int nums[] = {0, 0, 0, 0};
        //        List<List<Integer>> lists = new Main().threeSum(nums);
        //        System.out.println("lists = " + lists.toString());

        int nums2[] = {1, -2, -5, -4, -3, 3, 3, 5};
        List<List<Integer>> lists2 = new Main().fourSum(nums2, -11);
        System.out.println("lists2 = " + lists2.toString());

    }

}
