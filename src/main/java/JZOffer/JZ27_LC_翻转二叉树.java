package JZOffer;

import java.util.Stack;

public class JZ27_LC_翻转二叉树 {
	/*请完成一个函数，输入一个二叉树，该函数输出它的镜像。
	例如输入：
  4
 /  \
 2   7
/ \  / \
1  3 6  9
镜像输出：

  4
 /  \
 7   2
/ \  / \
9  6 3 1
*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //递归
	class Solution {
		public TreeNode mirrorTree(TreeNode root) {
			if (root==null) return null;
			TreeNode leftNode = mirrorTree(root.left);
			TreeNode rightNode = mirrorTree(root.right);
			root.left = rightNode;
			root.right = leftNode;
			return root;
		}
	}

	//迭代
		class Solution2 {
			public TreeNode mirrorTree(TreeNode root) {
				if(root == null) return null;
				Stack<TreeNode> stack = new Stack() {{ add(root); }};
				while(!stack.isEmpty()) {
					TreeNode node = stack.pop();
					if(node.left != null) stack.add(node.left);
					if(node.right != null) stack.add(node.right);
					TreeNode tmp = node.left;
					node.left = node.right;
					node.right = tmp;
				}
				return root;
			}
		}
}
