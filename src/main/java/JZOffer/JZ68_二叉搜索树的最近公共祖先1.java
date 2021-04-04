package JZOffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JZ68_二叉搜索树的最近公共祖先1 {
	/*给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。

*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
	//迭代
	class Solution {
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			TreeNode ancestor = root;
			while (true) {
				if (p.val < ancestor.val && q.val < ancestor.val) {
					ancestor = ancestor.left;
				} else if (p.val > ancestor.val && q.val > ancestor.val) {
					ancestor = ancestor.right;
				} else {
					break;
				}
			}
			return ancestor;
		}
	}



  //我搞成和普通树一样的做法了，我之前有想过单独处理二叉搜索树，但是不知道怎么回事就写回去了。
  class Solution1 {
	  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	  		if (root==null){
	  		    return null;
	  		}
	  		if (root.val>=p.val&&root.val<=q.val
			||	root.val<=p.val&&root.val>=q.val)
	  		{
	  		    return root;
	  		}
		  TreeNode left = lowestCommonAncestor(root.left, p, q);
		  TreeNode right = lowestCommonAncestor(root.right, p, q);

		  if (left==null){
		      return right;
		  }else if (right==null){
		      return left;
		  } else {
		  	return root;
		  }

	  }
  }


}
