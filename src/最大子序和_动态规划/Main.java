package 最大子序和_动态规划;

/**
 * 解法：
 * 这一题要维护两个变量：global和local，与上面一题一样，local保存包含当前元素的最大值（局部最优），
 * global保存的是所有情况里面的最大值（全局最优）。假设第i步的local[i]和global[i]已知，
 * 那么第i+1步的local[i + 1] = max{ nums[i + 1] + local[i], nums[i + 1] }， （局部最优解：合并或者从最新的那一个重新开始）
 * global[i + 1]  = max{global[i], local[i + 1]}。（全局最优解，将当前的局部最优解与之前的全局最优解比较）
 * <p>
 * 描述：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2019/7/30
 */

public class Main {

    public static void main(String[] args) {
        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(dp(a));
    }

    public static int dp(int nums[]) {
        if (nums == null) {
            return 0;
        }
        int local = nums[0]; // 局部最优解
        int global = nums[0]; //全局最优解
        for (int i = 1; i < nums.length; i++) {
            // 局部最优解：合并或者从最新的那一个重新开始 所以的出来的结果一定是连续的子集和
            local = local + nums[i] > nums[i] ? local + nums[i] : nums[i];
            // 全局最优解，将当前的局部最优解与之前的全局最优解比较
            global = local > global ? local : global;
        }
        return global;
    }

}
