package 最好的农场;

/**
 * 描述
 *
 * 背景
 * 在与入侵者的斗争中，农民威廉让全国各地的农民一起帮助国王击败入侵者。因此，国王决定在战争胜利后授予农民威廉一个伟大的农场。
 * 问题
 * 国王将他的国家划分为A * B网格，并用一对整数标记每个1 * 1的正方形。请参考下图作为示例：(4*4的网格 -1 -> 2)
 *
 * 尽管如此，并非所有正方形都可用。有些人被授予其他人，有些人在战争中被摧毁。所以国王只列出了可用的1 * 1方格，让威廉农场从中选择一些。与此同时，
 * 威廉不能选择所有的广场。他只能选择其中的一些，这样广场就可以形成一个连通的区域，从而建立他的农场。连接区域定义如下：
 * 1.连接区域由1 * 1个正方形组成;
 * 2.从这些1 * 1方格中的任何一个方块中，可以走到属于该区域的任何其他1 * 1方格，而不进入不在该区域内的某个方格;
 * 当站在广场上时，可以从四个方向走进相邻的广场：北，南，东，西。
 * 此外，每个可用的广场都有价值。威廉应该选择建立一个最有价值的农场（连通区）。换句话说，威廉应该选择形成连通区域的一些方形，其中方形值的总和是最大的。
 * 您在此问题中的任务是找出最大值。
 * 输入
 *
 * 输入包含几个测试用例。在每个测试用例的第一行中，有一个正整数N（1 <= N <= 200000），表示可用的正方形数。以下N行包含N个方块的信息，每行一个。在一行中，
 * 有三个整数xyv由一个空格分隔。（x，y）是该正方形的位置，v是其值。所有x和y都在带符号的16位整数范围内。值v是一个小于10000的非负整数。以一个零开头的测试用例
 * 是最终的测试用例，没有输出。
 * 产量
 *
 * 对于每个测试用例，打印你的答案，威廉可以建立他的农场的最大价值，在一行中没有任何多余的空间。
 * 样本输入
 *
 * 1
 * 0 0 1
 * 6
 * 0 1 1
 * 0 0 1
 * 1 0 1
 * 2 2 2
 * 2 1 2
 * 2 -1 1
 * 0
 * 样本输出
 *
 * 1
 * 4
 */

import java.util.Scanner;

public class Main {

    // 地图大小
    public static  final int MAX = 2000;
    // 标志数组 判断某坐标是否已经用过
    public static  int B[][] = new int[MAX][MAX];
    public static int next[][] = {
        {1,0}, //东
        {0,-1},//南
        {-1,0},//西
        {0,1} //北
    };
    public static int count = 0;

    /**
     * 深搜此坐标及附近坐标 统计价值之和
     * @param M
     * @param x
     * @param y
     */
    public static void dfs(int [][]M, int x, int y){
        if(isReturn(M,x,y)){
            return ;
        }

        count += M[x][y];
        B[x][y] = 1;
//        System.out.println(x+","+y+"可用，当前count:"+count);

        for (int i = 0; i < next.length; i++) {
            dfs(M,x+next[i][0],y+next[i][1]);
        }
    }

    /**
     * 判断此坐标是否可用
     * @param M 地图
     * @param x 坐标x
     * @param y 坐标y
     * @return
     */
    public static boolean isReturn(int [][]M, int x, int y){

        if(x < 0 || x>= M.length || y < 0 || y >= M[0].length){
            return true;
        }
        if(M[x][y] == 0){
            return true;
        }
        if(B[x][y] != 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 地图
        int M[][];

        // 最大价值
        int maxCount;
        int N = sc.nextInt();
        int x, y, v;

        // 存储输入的可用坐标
        int xs[] = new int[N];
        int ys[] = new int[N];

        // 计算原点
        int source = MAX/2 - 1;

        while(N != 0){
            M = new int[MAX][MAX];
            maxCount = 0;
            for (int i = 0; i < N; i++) {
                x = sc.nextInt();
                y = sc.nextInt();
                v = sc.nextInt();

                // 计算真正的位置
                x += source;
                y += source;
                M[x][y] = v;

                // 存储可用坐标
                xs[i] = x;
                ys[i] = y;
            }
//            long begin = System.currentTimeMillis();
            for (int i = 0; i < N; i++) {
                count = 0;

                // 此坐标已经被用过
                if(B[xs[i]][ys[i]] != 0){
                    continue;
                }
                // 计算此坐标及附近可用的价值
                dfs(M,xs[i],ys[i]);
//                System.out.println("count:"+count);

                // 算出最大价值
                if(count > maxCount){
                    maxCount = count;
                }
            }
//            long end = System.currentTimeMillis();
//            double excTime = (double)(end - begin) / 1000;
            System.out.println(maxCount);
//            System.out.println("用时："+excTime);
            N = sc.nextInt();
        }
        sc.close();
    }
}
