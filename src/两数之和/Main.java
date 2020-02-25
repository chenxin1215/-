package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * <给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。>
 *
 * @Author: chenxin
 * @Date: 2020/2/19
 */
public class Main {

    public static int[] twoSum(int[] nums, int target) {
        // key存数据 用于检索；value存下标 返回的数据
        Map<Integer, Integer> oldData = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer temp = target - nums[i];

            // temp 为期望值 如果map中存在 则满足条件 返回
            Integer j = oldData.get(temp);
            if (j != null) {
                int result[] = {j, i};
                return result;
            }

            oldData.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 11, 15};
        int[] twoSum = Main.twoSum(a, 9);

        if (twoSum != null) {
            System.out.println(twoSum[0] + ", " + twoSum[1]);
        }

    }

}
