package JZOffer;

public class JZ55_2_平衡二叉树 {
	/*输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
	如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。*/
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//思路1：递归计算左右子树的高度然后分别累加起来左右的高度。  -》不行
	//不会
	//最优思路：递归计算左右子树的深度，如果左右子树深度差不大于1，返回左右深度最大的那个。 如果大于1，直接返回-1结束递归。
	class Solution {
		public boolean isBalanced(TreeNode root) {
			return depth(root) == -1;
		}

		public int depth(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int le = depth(root.left);
			if (le == -1) {
				return -1;
			}
			int ri = depth(root.right);
			if (ri == -1) {
				return -1;
			}
			return Math.abs(le - ri) < 2 ? Math.max(le, ri) + 1 : -1;
		}
	}

	//思路1的实现方式。
	class Solution1 {
		public boolean isBalanced(TreeNode root) {
			if (root == null) return true;
			return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}

		private int depth(TreeNode root) {
			if (root == null) return 0;
			return Math.max(depth(root.left), depth(root.right)) + 1;
		}
	}
}


