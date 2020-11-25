package 中等题;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q39_组合总数 {

    //求一个集合的所有子集
    //经典的回溯算法使用
//    class Solution {
        List<List<Integer>> res  =  new ArrayList();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0 || target < 0) {
                return res;
            }
            List<Integer> list = new ArrayList<>();
            process(0,candidates,target,list);

            return res;
        }

        public void process(int start,int[] candidates,int target,List<Integer> list){
            if (target <0 ) return;
            else if (target==0) res.add(new ArrayList<>(list));
            else {
                for (int i = start; i <candidates.length ; i++) {
                    list.add(candidates[i]);
                    process(i,candidates,target-candidates[i],list);
                    list.remove(list.size()-1);
                }
            }
        }
//    }
}
