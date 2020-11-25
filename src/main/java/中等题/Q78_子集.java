package 中等题;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Q78_子集 {
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            ArrayList<Integer> list = new ArrayList<>();
            process(0,nums,list);
            return res;
        }

        public void process(int start,int[] nums,List<Integer> list){
//            if (list.size()==nums.length) return;
            res.add(new ArrayList<>(list));
            for (int i = start; i <nums.length; i++) {
                    list.add(nums[i]);
                    process(i+1,nums,list);
                    list.remove(list.size()-1);
            }
        }
    }
}
