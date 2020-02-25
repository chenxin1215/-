package 跳跃游戏_动态规划;

/**
 * 解法：用一个global变量保存到目前为止能跳的最远距离，并且保证当前能跳到的地方一定是大于当前位置的，确保不走到不能跳到的地方
 * 循环结束后，如果没有达到最后一个之后，表示不能跳到终点
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: chenxin
 * @Date: 2019/7/30
 */

public class Main {

    public static void main(String[] args) {
        int a[] = {2, 3, 1, 1, 4};
        int b[] = {3, 2, 1, 0, 4};
        System.out.println(dp(b));
    }

    public static boolean dp(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length && sum >= i; i++) {
            System.out.print("sum: "+sum+" -> ");
            // 保存到目前为止能跳的最远距离
            sum = nums[i] + i > sum ? nums[i] + i : sum;
            System.out.println(sum);
        }
        return sum >= nums.length;
    }
}
