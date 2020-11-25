package 简单题;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Q1207_独一无二的出现次数 {
    /*给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。

示例 1：
输入：arr = [1,2,2,1,1,3]
输出：true
解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。
没有两个数的出现次数相同。
*/
//    @Test
//    public void test() {
//        int[] a = {1, 2, 2, 1, 1, 3};
////        int[] a = {1, 1, 2, 2};
//        boolean b = uniqueOccurrences(a);
//        System.out.println(b);
//    }


    class Solution {
        public boolean uniqueOccurrences(int[] arr) {

//            if (arr.length == 2 && arr[1] != arr[0]) return false;
            HashSet<Integer> s = new HashSet<>();

            Arrays.sort(arr);

            int tmp = 1;
            for (int i = 0; i < arr.length; i++) {

                if (i < arr.length - 1) {
                    if (arr[i] == arr[i + 1]) tmp++;
                    else {
                        if (s.contains(tmp)) {
                            return false;
                        } else {
                            s.add(tmp);
                        }
                        tmp = 1;
                    }
                } else {
                    if (s.contains(tmp)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


}
