package 简单题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Q1365_有多少小于当前数字的数字 {
    /*
    * 给你一个数组 nums，对于其中每个元素 nums[i]，
    * 请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，
* 其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。
示例 1：
输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
解释：
示例 2：
输入：nums = [6,5,4,8]
输出：[2,1,0,3]
示例 3：

输入：nums = [7,7,7,7]
输出：[0,0,0,0]
。*/

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {

            int[] tmp = new int[101];
            for (int i = 0; i < nums.length; i++) {
                tmp[nums[i]]++;
            }

            for (int i = 1; i <tmp.length ; i++) {
                tmp[i] +=tmp[i-1];
            }

            int[] res = new int[nums.length];
            for (int i = 1; i <res.length ; i++) {
                res[i] = tmp[nums[i]-1];
            }

            return res;

        }
    }







    class Solution1 {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] tmp = nums.clone();
            Arrays.sort(tmp);
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i <tmp.length ; i++) {
                if (map.get(tmp[i])!=null){
                    map.put(tmp[i],map.get(tmp[i-1])+1);
                }else map.put(tmp[i],1);
            }



            int[] res = new int[nums.length];

            for (int i = 0; i <res.length ; i++) {
                for (Integer integer : map.keySet()) {
                    if (integer<nums[i]){
                        res[i]+= map.get(integer);
                    }
                }
            }

            return res;

        }
    }
}
