package 简单题;

import org.junit.Test;

public class Q941_有效的山脉数组 {
    /*给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
    让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
    A.length >= 3
    在 0 < i < A.length - 1 条件下，存在 i 使得：
    A[0] < A[1] < ... A[i-1] < A[i]
    A[i] > A[i+1] > ... > A[A.length - 1]
    注意是严格的大于和小于，如果存在等于那么也返回false
    */


//    @Test
//    public void test() {
//        int[] a = {0, 3, 2, 1};
//        System.out.println(validMountainArray(a));
//    }

    class Solution {
        public boolean validMountainArray(int[] A) {
            if (A.length<3) return false;
            int l=0,r=A.length-1;
            while (l< A.length-2 && A[l]<A[l+1]) l++;
            while (r>1 && A[r]<A[r-1]) r--;

            return l==r;
        }
    }





    // 第一遍，憨憨写法
//    class Solution {
//            public boolean validMountainArray(int[] A) {
//            if (A.length < 3) return false;
//
//            int pos = 0;
//            int max = 0;
//            for (int i = 0; i < A.length; i++) {
//                if (A[i] > max) {
//                    max = A[i];
//                    pos = i;
//                }
//            }
//            if (pos == 0 || pos == A.length - 1) return false;
//            int l = pos - 1, r = pos + 1;
//            int lpre = A[pos], rpre = A[pos];
//            while (l >= 0 || r < A.length) {
//                if (l >= 0) {
//                    if (A[l] >= lpre) {
//                        return false;
//                    }
//                    lpre = A[l];
//                    l--;
//                }
//                if (r < A.length) {
//                    if (A[r] >= rpre) {
//                        return false;
//                    }
//                    rpre = A[r];
//                    r++;
//                }
//            }
//            return true;
//        }
//    }
}

