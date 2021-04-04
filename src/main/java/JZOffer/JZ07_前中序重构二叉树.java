package JZOffer;

import java.util.HashMap;
import java.util.Map;

public class JZ07_前中序重构二叉树 {
	/*输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  //有一说一，不会
	//看了一眼题解：通过前序列表找到根节点，将中序列表分为左右子树，递归。
	//我不知道怎么实现。
	class Solution {
		int[] preorder;
		Map<Integer,Integer> map = new HashMap<>();
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			this.preorder=preorder;
			for (int i = 0; i < inorder.length; i++) {
				map.put(inorder[i],i);
			}
			return recur(0,0,preorder.length-1);
		}

		/*
		* 一定要注意递归方法的参数的意义
		* 左子树递归：第一个参数是对应的在先序遍历列表中的根节点，因为先序遍历时左子树会依次经过根节点
		* 右子树递归：第一个参数是对应的在先序遍历列表中的右子树的根节点，因为先序遍历列表是 根节点|左子树|右子树
		* 所以我们需要通过中序遍历获得左子树的长度，(然后加上根节点对应的位置)才能得到右子树的根节点在 先序遍历列表中对应的位置
		* */
		public TreeNode recur(int root,int l,int r){
			if (l>r){
			    return null;
			}
			Integer idx = map.get(preorder[root]);
			TreeNode node = new TreeNode(preorder[root]);
			node.left=recur(root+1,l,idx-1);
			node.right=recur(root+idx-l+1,idx+1,r);
			return node;
		}
	}
}
