package 数据结构.简单;

import java.util.*;

public class Q501_二叉搜索树种的众数 {
    /*给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：

给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
    * */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution2 {
        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];
            HashMap<Integer, Integer> map = new HashMap<>();
            preOrder(root, map);

            ArrayList<Integer> res = new ArrayList<>();
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            Integer max = Collections.max(map.values());
            for (Map.Entry<Integer, Integer> e : entries
            ) {
                if (e.getValue() == max) res.add(e.getKey());
            }

            return res.stream().mapToInt(i -> i).toArray();

        }

        void preOrder(TreeNode root, Map<Integer, Integer> map) {
            if (root == null) return;
            if (map.containsKey(root.val)) {
                map.put(root.val, map.get(root.val) + 1);
            } else {
                map.put(root.val, 1);
            }
            preOrder(root.left, map);
            preOrder(root.right, map);
            return;
        }

    }




}




















