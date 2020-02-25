package 阶乘函数后K个零;

public class Solution {

    public static void main(String[] args) {
        int n = 15;
        int sum = 1;
        for (int i = n; i > 0; i--){
            sum *= i;
        }
        System.out.println(sum);
    }
}
