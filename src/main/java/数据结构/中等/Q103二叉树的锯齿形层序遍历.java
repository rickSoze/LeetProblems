package 数据结构.中等;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Q103二叉树的锯齿形层序遍历 {
	/*给定一个二叉树，返回其节点值的锯齿形层序遍历。
	（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
	* */
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //层序遍历，判断是从左到右还是从右到左即可
	class Solution {
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			ArrayList<List<Integer>> res = new ArrayList<>();
			if(root==null){
				return res;
			}

			boolean l2r=true;
			ArrayList<TreeNode> queue = new ArrayList<>();

			queue.add(root);
			while (!queue.isEmpty()){
				int len = queue.size();
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 0; i < len; i++) {
					if (l2r){
						TreeNode tmp = queue.remove(len-i-1);
						list.add(tmp.val);
						if (tmp.left!=null){
							queue.add(tmp.left);
						}
						if (tmp.right!=null){
							queue.add(tmp.right);
						}

					}else {
						TreeNode tmp = queue.remove(len-i-1);
						list.add(tmp.val);
						if (tmp.right!=null){
							queue.add(tmp.right);
						}
						if (tmp.left!=null){
							queue.add(tmp.left);
						}
					}
				}
				res.add(new ArrayList<>(list));
				l2r=!l2r;
			}
			return res;
		}
	}
}
