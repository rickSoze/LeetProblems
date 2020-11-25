package 中等题;

import org.junit.Test;

import java.util.*;

public class Q47_全排列II {
    /*
    * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
示例:
输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/


//    @Test
//    public void test(){
//        System.out.println(permuteUnique(new int[]{1, 1, 2}));
//        System.out.println(2);
//    }

    //注意去重

//    class Solution {
//        public List<List<Integer>> permuteUnique(int[] nums) {
//            Arrays.sort(nums);
//          List<List<Integer>> res = new ArrayList<>();
//          process(-1,nums,new ArrayList<Integer>(),res);
//          return res;
//        }
//
//        public void process(int start,int[] nums, List<Integer> list,List<List<Integer>> res){
//            if (list.size()==nums.length){
//                res.add(new ArrayList<>(list));
//                return;
//            }
//            for (int i = 0; i <nums.length ; i++) {
//                if (nums[i]==nums[i-1])
//                if (i==start) continue;
//                list.add(nums[i]);
//                process(i,nums,list,res);
//                list.remove(list.size()-1);
//            }
//        }
//
//    }


    class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            int len = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 排序（升序或者降序都可以），排序是剪枝的前提
            Arrays.sort(nums);

            boolean[] used = new boolean[len];
            // 使用 Deque 是 Java 官方 Stack 类的建议
            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(nums, len, 0, used, path, res);
            return res;
        }

        private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
            if (depth == len) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < len; ++i) {
                if (used[i]) {
                    continue;
                }

                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, used, path, res);
                // 回溯部分的代码，和 dfs 之前的代码是对称的
                used[i] = false;
                path.removeLast();
            }
        }
    }








}
