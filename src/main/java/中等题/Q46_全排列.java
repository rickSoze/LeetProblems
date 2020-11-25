package 中等题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Q46_全排列 {
    //回溯法

//    class Solution {
    @Test
        public void test(){
        List<List<Integer>> a = permute(new int[]{1, 2, 3,4,5,6});
        System.out.println(a);
    }
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if (nums.length==0||nums==null) return res;

            ArrayList<Integer> list = new ArrayList<>();
            process(nums,list);
            return res;
        }

        public void process(int[] nums,List<Integer> list){
            if (list.size()==nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i =0; i <nums.length ; i++) {
                if (!list.contains(nums[i]))
                 {
                    list.add(nums[i]);
                    process(nums,list);
                    list.remove(list.size()-1);
                 }
            }

        }
//    }
}
