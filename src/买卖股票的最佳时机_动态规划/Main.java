package 买卖股票的最佳时机_动态规划;

/**
 * 解题思路1：
 * 因为不能在买入前卖出，我们要计算的是：最大的卖出价 - 最小的买入价 ， 所以我们首先要知道最大的卖出价，
 * 所以我们从逆序遍历数组，设最后一个为初始的最大卖出价， 然后我们遍历时，把当前元素作为买入价，计算最大利润。记住 同时计算并更新最大卖出价。
 * <p>
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: chenxin
 * @Date: 2019/7/31
 */

public class Main {

    public static void main(String[] args) {
        int a[] = {7, 1, 5, 3, 6, 4};
        int b[] = {7, 6, 4, 3, 1};
        System.out.println(dp1(a));
        System.out.println(dp2(b));
    }

    public static int dp1(int nums[]) {

        if (nums.length == 0) {
            return 0;
        }
        int profit = 0; //最大利润
        int maxSellPrice = nums[nums.length - 1]; // 最大卖出价格
        for (int i = nums.length - 1; i >= 0; i--) {
            // 更新最大卖出价
            maxSellPrice = nums[i] > maxSellPrice ? nums[i] : maxSellPrice;
            // 更新利润
            profit = maxSellPrice - nums[i] > profit ? maxSellPrice - nums[i] : profit;
        }
        return profit;
    }

    public static int dp2(int nums[]){
        if (nums.length == 0) {
            return 0;
        }
        int local = 0;
        int global = 0;

        for (int i = 1; i < nums.length; i++) {
            // 局部最优解 为了后续的计算 只要是有利润的 就更新局部最优解
            local = nums[i] - nums[i-1] + local > 0 ? nums[i] - nums[i-1] + local : 0;
            global = local > global ? local : global;
        }

        return global;
    }

}
