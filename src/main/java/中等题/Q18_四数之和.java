package 中等题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q18_四数之和 {
    /*给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
    使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
示例：
给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
满足要求的四元组集合为：
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
//    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            ArrayList<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            process(nums,target,0,new ArrayList<Integer>(),res);
            return res;
        }

        public void process(int[] nums, int tar,int start,List<Integer> path,List<List<Integer>> res){
            if (path.size()==4 && tar==0){
                res.add(new ArrayList<>(path));
                return;
            }

            if (path.size()>4) return;
            for (int i = start; i <nums.length ; i++) {
                //去重
                if (i>start && nums[i]==nums[-1]) continue;

                if(i<nums.length-1 && tar-nums[i+1]<0) return;

//                if (i<nums.length-1 && tar-nums[i] -nums[nums.length-1] >0) continue;
                path.add(nums[i]);
                process(nums, tar-nums[i], i+1, path, res);
                path.remove(path.size()-1);
            }
        }
//    }

    @Test
    public void  test(){
//        System.out.println(fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));

    }
}
