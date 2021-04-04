package JZOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class JZ32从上到下打印二叉树 {
	/*从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
例如:
给定二叉树:[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
*/
	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  //迭代实现层序遍历，依次输出；  每次记录一下那一层有多少个节点接即可
	//list每次直接新建会更快。
	class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			ArrayList<List<Integer>> ret = new ArrayList<>();
			if (root==null){
			    return ret;
			}

			ArrayDeque<TreeNode> queue = new ArrayDeque<>();

			queue.addFirst(root);
			while (!queue.isEmpty()){
				int size = queue.size();
				ArrayList<Integer> list = new ArrayList<>();
				for (int i = 0; i <size ; i++) {
					TreeNode node = queue.removeFirst();
					if (node.left!=null){
					    queue.addLast(node.left);
					}
					if (node.right!=null){
					    queue.addLast(node.right);
					}
					list.add(node.val);
				}
				ret.add(list);
//				list.clear();
			}
			return  ret;
		}
	}

	//采用递归的方式，巧妙之处在于我记录当前节点是第几层的，我直接把这个节点加入到对应的层数那个列表中去。
	class Solution1 {
		List<List<Integer>> node=new ArrayList();
		public List<List<Integer>> levelOrder(TreeNode root) {
			lei(root,0);
			return node;
		}
		public void lei(TreeNode root,int k){
			if(root!=null){
				if(node.size()<=k)node.add(new ArrayList());
				node.get(k).add(root.val);
				lei(root.left,k+1);
				lei(root.right,k+1);
			}
		}
	}
}
