package 中等题;

import org.junit.Before;
import org.junit.Test;

public class Q845_数组中的最长山脉 {
    /*我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

B.length >= 3
存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
（注意：B 可以是 A 的任意子数组，包括整个数组 A。）

给出一个整数数组 A，返回最长 “山脉” 的长度。
如果不含有 “山脉” 则返回 0。
示例 1：
输入：[2,1,4,7,3,2,5]
输出：5
解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
示例 2：
输入：[2,2,2]
输出：0
解释：不含 “山脉”。
。*/



    @Test
    public void test(){
        int[] a = {2, 1, 4, 7, 3, 2, 5};
//        int[] a = {2, 3};
        int i = longestMountain(a);
        System.out.println(i);
    }
//    class Solution {
        public int longestMountain(int[] A) {
        if (A.length<3) return 0;
            int res=0;

            for (int i = 1; i <A.length-1;) {

                if (A[i]>A[i-1]&&A[i]>A[i+1]){
                    int l = i - 1;
                    int r = i + 1;

                    while (l > 0 && A[l - 1] < A[l]) {
                        l--;
                    }

                    while (r < A.length - 1 && A[r + 1] < A[r]) {
                        r++;
                    }

                    res = Math.max(res, (r - l + 1));
                    i = r;
                }else {
                    i++;
                }
            }

            return res;
        }
//    }
}


























