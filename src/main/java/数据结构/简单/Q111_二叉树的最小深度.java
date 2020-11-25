package 数据结构.简单;

public class Q111_二叉树的最小深度 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//  @Test
//  public void test(){
//      TreeNode treeNode = new TreeNode(1);
//      treeNode.left = new TreeNode(2);
//      treeNode.right = new TreeNode(2);
//      treeNode.right.right = new TreeNode(2);
//      treeNode.left.right = new TreeNode(2);
//      treeNode.right.left = new TreeNode(2);
//      treeNode.left.left = new TreeNode(2);
//
//      System.out.println(minDepth(treeNode));
//
//  }
    //使用递归的方法 每次返回左右子树中高度小的那一个

    class Solution {
        public int minDepth(TreeNode root) {
             return getDepth(root);
        }

        public int getDepth(TreeNode root){
            if (root.left==null && root.right==null) return 1;
            if (root.left!=null && root.right != null)
           {
            int l = getDepth(root.left);
            int r = getDepth(root.right);
            return (l>r?r:l)+1;
           }

            return getDepth(root.left==null?root.right:root.left)+1;

        }
    }
}
