package JZOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JZ54_二叉搜索树第k大节点 {
	/*
	给定一棵二叉搜索树，请找出其中第k大的节点。
示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4

*/

	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

	//唯一思路： 中序遍历得到递增的序列输出倒数第k个即可。
	class Solution {
		List<Integer> list = new ArrayList<>();
		public int kthLargest(TreeNode root, int k) {

			inOrder(root);
			return list.get(list.size()-k);
		}
		public void inOrder(TreeNode node){
			if (node.left!=null){
				inOrder(node.left);
			}
			list.add(node.val);
			if (node.right!=null){
				inOrder(node.right);
			}
		}
	}

	//我最开始也想的直接后序遍历得到递减序列，到第k次直接返回即可；但是我以为后序遍历得不到递减序列
	//然后后序遍历可以得到递减序列
	//以下代码可以优化
	class Solution2 {
		int res=0;
		int cnt=1;
		public int kthLargest(TreeNode root, int k) {
			inOrder(root,k);
			return res;
		}
		public void inOrder(TreeNode node,int k){

			if (node.right!=null){
			inOrder(node.right,k);
			}

			if (cnt==k){
			    res=node.val;
			    cnt++;
			    return;
			}else if (cnt>k){
			    return;
			}
			cnt++;

			if (node.left!=null){
				inOrder(node.left,k);
			}
		}
	}

	class Solution3 {
		int res, k;
		public int kthLargest(TreeNode root, int k) {
			this.k = k;
			dfs(root);
			return res;
		}
		void dfs(TreeNode root) {
			if(root == null) return;
			dfs(root.right);
			if(k == 0) return;
			if(--k == 0) res = root.val;
			dfs(root.left);
		}
	}


}
