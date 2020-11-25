package 中等题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q491_递增子序列 {
    /*给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
示例:
输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

    * */

//    @Test
//    public void test(){
////        System.out.println(findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
//        System.out.println(findSubsequences(new int[]{4,6,7,7}));
////        System.out.println(findSubsequences(new int[]{100,90,80,70,60,50,60,70,80,90,100}));
//    }
//        class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
//           if (nums==null || nums.length==0) return res;
            ArrayList<Integer> list = new ArrayList<>();
            process(-1,nums,list);
            return res;
        }

        public void process(int start,int[] nums,List<Integer> list){
//            if (list.size()>=2 && !res.contains(list)) res.add(new ArrayList<>(list));
            if (list.size()>1) res.add(new ArrayList<>(list));
//
            HashSet<Integer> set = new HashSet<>();
            for (int i = start+1; i <nums.length; i++) {
                if (set.contains(nums[i])) continue;
                set.add(nums[i]);
                if ( start==-1||nums[start]<=nums[i]){
                    list.add(nums[i]);
                    process(i,nums,list);
                    list.remove(list.size()-1);
                }
            }

        }
//    }

}
