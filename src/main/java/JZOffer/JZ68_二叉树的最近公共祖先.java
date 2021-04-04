package JZOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JZ68_二叉树的最近公共祖先 {
	/*给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //分别在左右子树中寻找公共节点
  class Solution {
	  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		  if (root == null || root == p || root == q) {
			  return root;
		  }

		  TreeNode left = lowestCommonAncestor(root.left, p, q);
		  TreeNode right = lowestCommonAncestor(root.right, p, q);

		  if (left == null) {
			  return right;
		  } else if (right == null) {
			  return left;
		  } else return root;
	  }
  }


  //通过记录每个节点的父亲是谁，然后从目标节点开始遍历自己的父亲，得到一个集合，判断另一个目标节点是否在这个集合中即可
	class Solution2 {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			HashMap<Integer, TreeNode> map = new HashMap<>();
			inOrder(root,map);
			HashSet<TreeNode> set = new HashSet<>();
			set.add(p);
			while (p!=root){
				TreeNode pp = map.get(p.val);
				set.add(pp);
				p=pp;
			}
			if (set.contains(q)){
				return q;
			}
			while (q!=root){
				TreeNode qp = map.get(q.val);
				if (set.contains(qp)){
				    return qp;
				}
				q=qp;
			}
			return root;
		}

		public void inOrder(TreeNode root, Map map){

			if (root.left!=null){
				map.put(root.left.val,root);
				inOrder(root.left,map);
			}

			if (root.right!=null){
				map.put(root.right.val,root);
				inOrder(root.right,map);
			}
		}

	}

}
