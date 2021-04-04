package 简单题;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Q217_存在重复元素 {
    /*
    * 给定一个整数数组，判断是否存在重复元素。
      如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
    * */


    //先排序，如果有两个一样的元素，那么它们挨在一起
    class Solution {
        public boolean containsDuplicate(int[] nums){
            Arrays.sort(nums);
            for (int i = 0; i <nums.length ; i++) {
                if (nums[i]==nums[i+1]) return true;
            }
            return false;
         }
    }

    class Solution2 {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])){
                 return true;
                }else {
                    set.add(nums[i]);
                }
            }
            return false;
        }
    }

    class Solution3 {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                    set.add(nums[i]);
            }
            return !(set.size()==nums.length);
        }
    }
}

