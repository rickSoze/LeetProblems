package 简单题;

import org.junit.Test;

import java.util.Arrays;

public class Q976_三角形的最大周长 {
    /*
给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
如果不能形成任何面积不为零的三角形，返回 0。

示例 1：
输入：[2,1,2]
输出：5

输入：[3,2,3,4]
输出：10*/

//    @Test
//    public void test(){
//        int[] a = {1, 2, 2};
//        System.out.println(largestPerimeter(a));
//    }
    class Solution {
        public int largestPerimeter(int[] A) {
            Arrays.sort(A);

            for (int i = A.length-1; i > 1; i--) {
                int a=A[i];
                int b=A[i-1];
                int c=A[i-2];
                if (a<c+b) return a+c+b;
            }
            return 0;
        }
    }
}
