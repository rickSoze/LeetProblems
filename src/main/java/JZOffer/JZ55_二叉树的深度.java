package JZOffer;

import org.junit.Test;

import java.util.logging.Level;

public class JZ55_二叉树的深度 {
	/*输入一棵二叉树的根节点，求该树的深度。
	从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
例如：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。

*/
	class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 //递归，每次计算当前节点左右子树中高度最大的那个，然后返回即可。
	//因为前面已经判断了null，所以不用再判断左右节点是否为空；同时没有必要定义变量
	class Solution {
		public int maxDepth(TreeNode root) {
			if(root==null) return 0;

			int left=0,right=0;
			if (root.left!=null){
			     left = maxDepth(root.left);
			}
			if (root.right!=null){
				right = maxDepth(root.right);
			}
			return Math.max(left,right)+1;
		}
	}
	//优化之后
	class Solution2 {
		public int maxDepth(TreeNode root) {
			if(root==null) return 0;
			return Math.max(maxDepth(root.right),maxDepth(root.right))+1;
		}
	}
}
