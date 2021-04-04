package 数据结构.中等;

import java.util.ArrayList;
import java.util.List;

public class Q98_验证二叉搜索树 {
	/*给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

	//傻逼了，艹 二叉搜索树直接中序遍历是递增的就行
	//使用递归可以避免要遍历整个树才能判断结果
	class Solution {

		public boolean isValidBST(TreeNode root) {
			ArrayList<Integer> list = new ArrayList<>();
			inOrder(root,list);
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i)<=list.get(i-1)){
				    return false;
				}
			}
			return true;
		}

		public void inOrder(TreeNode root, List<Integer> list){
			if (root!=null){
			    if (root.left!=null){
			        inOrder(root.left,list);
			    }
			    list.add(root.val);
				if (root.right!=null){
					inOrder(root.right,list);
				}
			}else {
				return;
			}
		}
	}

//递归：
class Solution1 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null) {
			return true;
		}

		int val = node.val;
		if (lower != null && val <= lower) {
			return false;
		}
		if (upper != null && val >= upper) {
			return false;
		}

		if (!helper(node.right, val, upper)) {
			return false;
		}
		if (!helper(node.left, lower, val)) {
			return false;
		}
		return true;
	}
}



	//只判断当前节点和其子节点之间是否满足条件是不行的，因为可能爷爷节点不满足
	class Solution2 {
		boolean res=true;
		public boolean isValidBST(TreeNode root) {
			if (root.left!=null) {
				if (root.val >= root.left.val) {
					judge(root.left, true);
				} else {
					return false;
				}
			}

			if (root.right!=null ) {
				if (root.val<=root.right.val){
					judge(root.right,false);
				}else {
					return false;
				}
			}

			return res;
		}
		public void judge(TreeNode root,boolean left){
			if (left){
				if (root.left!=null) {
					if (root.val >= root.left.val) {
						judge(root.left, true);
					} else {
						res= false;
					}
				}
			}else {

				if (root.right!=null ) {
					if (root.val<=root.right.val){
						judge(root.right,false);
					}else {
						res= false;
					}
				}
			}
		}
	}
}
