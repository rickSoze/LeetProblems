package 中等题;

import java.util.*;

public class Q40_组合总数II {
    /*
    * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用一次。
说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

    class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int len = candidates.length;
            List<List<Integer>> res = new ArrayList<>();
            if (len == 0) {
                return res;
            }

            // 关键步骤
            Arrays.sort(candidates);

            Deque<Integer> path = new ArrayDeque<>(len);
            dfs(candidates, len, 0, target, path, res);
            return res;
        }

        /**
         * @param candidates 候选数组
         * @param len        冗余变量
         * @param begin      从候选数组的 begin 位置开始搜索
         * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
         * @param path       从根结点到叶子结点的路径
         * @param res
         */
        private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < len; i++) {
                // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
                if (target - candidates[i] < 0) {
                    break;
                }

                // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                path.addLast(candidates[i]);
                // 调试语句 ①
                // System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));

                // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
                dfs(candidates, len, i + 1, target - candidates[i], path, res);

                path.removeLast();
                // 调试语句 ②
                // System.out.println("递归之后 => " + path + "，剩余 = " + (target - candidates[i]));
            }
        }

    }








    //为了去重，先排序，把相同的数排除了即可
    //如果用contains判断，效率较低，但是都要排序，不够高效
    class Solution2 {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            process(candidates,0,target,new ArrayList<>());
            return res;
        }

        public void process(int[] num,int start,int tar,List<Integer> list){
//            if (tar==0&&!res.contains(list)){
            if (tar==0){
                res.add(new ArrayList<>(list));
            }
            if (tar<0) return;

            for (int i = start; i < num.length; i++) {
                if (i>start&&num[i]==num[i-1]) continue;
                list.add(num[i]);
                process(num,i+1,tar-num[i],list);
                list.remove(list.size()-1);
            }
        }

    }
}













