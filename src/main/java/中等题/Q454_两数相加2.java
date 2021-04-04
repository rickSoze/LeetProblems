package 中等题;

import java.util.HashMap;
import java.util.Map;

public class Q454_两数相加2 {
    /*给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
如:
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:
2
解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*/
    //优化之后：
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) for (int b : B) map.compute(a + b, (k, v) -> v == null ? 1 : v + 1);
        for (int c : C) for (int d : D) res += map.getOrDefault(-c - d, 0);
        return res;
    }


    class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            HashMap<Integer, Integer> map = new HashMap<>();

            int cnt=0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    map.put(A[i]+B[j],map.get(A[i]+B[j])==null?1:map.get(A[i]+B[j])+1);
                }
            }

            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    if (map.get(-(C[i]+D[j]))!=null){
                        cnt+=map.get(-(C[i]+D[j]));
                    }
                }
            }
            return cnt;
        }
    }
}
