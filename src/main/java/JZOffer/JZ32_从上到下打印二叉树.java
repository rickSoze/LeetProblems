package JZOffer;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class JZ32_从上到下打印二叉树 {
	/*从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树:[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]
*/

	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

	class Solution {
		//1：简单的层序遍历
		//2：也可以递归实现
 		public int[] levelOrder(TreeNode root) {
			if (root==null){
			    return new int[0];
			}
			ArrayList<Integer> list = new ArrayList<>();
			ArrayDeque<TreeNode> queue = new ArrayDeque<>();

			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			int[] res = new int[list.size()];
			for (int i = 0; i < res.length; i++) {
				res[i]=list.get(i);
			}
			return res;
		}
	}
}
