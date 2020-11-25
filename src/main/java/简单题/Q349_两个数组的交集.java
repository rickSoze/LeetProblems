package 简单题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Q349_两个数组的交集 {
    /*给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
*/

//排序双指针
class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1==null || nums2==null) return null;

            HashSet<Integer> s = new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                s.add(nums1[i]);
            }

            HashSet<Integer> res = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                if (s.contains(nums2[i])){
                    res.add(nums2[i]);
                }
            }

            int[] arr = new int[res.size()];

            int i=0;
            for (Integer a :res
                 ) {
                arr[i++]=a;
            }

            return arr;
        }
    }
}
