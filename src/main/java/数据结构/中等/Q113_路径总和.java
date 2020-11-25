package 数据结构.中等;

import java.util.ArrayList;
import java.util.List;

public class Q113_路径总和 {
    /*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明: 叶子节点是指没有子节点的节点。
示例:
给定如下二叉树，以及目标和 sum = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
*/


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

     class Solution {
        ArrayList<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null) return res;
            process(root, 0, sum, new ArrayList<Integer>());
            return res;
        }

        public void process(TreeNode root, int sum, int tar, List<Integer> path) {
            path.add(root.val);
            sum += root.val;

            if (sum == tar && root.left == null && root.right == null) {
                res.add(new ArrayList<>(path));
                return;
            }

            if (root.left != null) {
                process(root.left, sum, tar, path);
                path.remove(path.size() - 1);
            }
            if (root.right != null) {
                process(root.right, sum, tar, path);
                path.remove(path.size() - 1);
            }
            return;
        }
    }
}











