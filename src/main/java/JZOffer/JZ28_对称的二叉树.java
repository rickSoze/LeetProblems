package JZOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class JZ28_对称的二叉树 {
	/*请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
例如，二叉树[1,2,2,3,4,4,3] 是对称的。

  1
 / \
 2  2
/ \ / \
3 4 4 3
但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:

   1
  / \
 2  2
  \  \
   3   3

示例 1：
输入：root = [1,2,2,3,4,4,3]
输出：true
*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 //思路1：层序遍历，判断是否回文。   很麻烦，不应该这么做。 我试试~  对于用例2无法判断
	//改进：在添加到队列的过程中，应该分别让左子树的右节点和右子树的左节点比较，这样才能体现对称

//思路2：递归
	class Solution {
		public boolean isSymmetric(TreeNode root) {
			if (root==null||(root.left==null&&root.right==null)){
			    return true;
			}
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root.left);
			queue.add(root.right);
			while (!queue.isEmpty()){
				TreeNode left = queue.removeFirst();
				TreeNode right = queue.removeFirst();

				if (left==null && right==null){
					continue;
				}
				if (left==null||right==null){
				    return false;
				}
				if (left.val!=right.val){
				    return false;
				}
				queue.add(left.left);
				queue.add(right.right);

				queue.add(left.right);
				queue.add(right.left);
			}
			return true;
		}
	}
	class Solution2 {
		public boolean isSymmetric(TreeNode root) {
			return root == null ? true : recur(root.left, root.right);
		}
		boolean recur(TreeNode L, TreeNode R) {
			if(L == null && R == null) return true;
			if(L == null || R == null || L.val != R.val) return false;
			return recur(L.left, R.right) && recur(L.right, R.left);
		}
	}

}
