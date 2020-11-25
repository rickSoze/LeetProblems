package 数据结构.中等;

import java.util.ArrayList;
import java.util.List;

public class Q114_二叉树展开为链表 {
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
//方法一： 通过前序遍历把所有节点存到容器中，然后遍历容器组成链表；
    //注意重新组成链表时把父节点的左节点置null

    class Solution1 {
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            preorderTraversal(root, list);
            int size = list.size();
            for (int i = 1; i < size; i++) {
                TreeNode prev = list.get(i - 1), curr = list.get(i);
                prev.left = null;
                prev.right = curr;
            }
        }

        public void preorderTraversal(TreeNode root, List<TreeNode> list) {
            if (root != null) {
                list.add(root);
                preorderTraversal(root.left, list);
                preorderTraversal(root.right, list);
            }
        }
    }




    //如果左子树为空，该节点不需要展开，如果左子树不为空，
    //把当前节点的右子树接到左子树最右边的节点处，然后左子树变为当前节点的右子树，并置null左子树；
    //依次往后遍历；

    class Solution2 {
        public void flatten(TreeNode root) {
            TreeNode cur = root;
            while (cur!=null){
                if (cur.left!=null){
                    TreeNode next = cur.left;
                    TreeNode pred = next;
                    while (pred.right !=null){
                        pred = pred.right;
                    }
                    pred.right = cur.right;
                    cur.left = null;
                    cur.right = next;
                }
                cur = cur.right;
            }
        }
    }
}
