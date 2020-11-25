package 中等题;

import org.junit.Test;

import java.util.*;

public class Q216_组合总数 {
    /*
   * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
   * 并且每种组合中不存在重复的数字。

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: k = 3, n = 7
输出: [[1,2,4]]
*/
//@Test
//   public void test(){
//    System.out.println(combinationSum3(3, 7));
//
//}



//    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> res = new ArrayList<>();
            process(0,n,k,new ArrayList<Integer>(),res);
            return res;
        }
        public void process(int start,int tar,int k,List<Integer> list,List<List<Integer>> res){
            if (tar==0 && list.size()==k){
                res.add(new ArrayList<>(list));
            }
            for (int i = start+1; i <=9 ; i++) {
                if (tar-i<0) return;
                list.add(i);
                process(i,tar-i,k,list,res);
                list.remove(list.size()-1);
            }
        }
    }
//}
