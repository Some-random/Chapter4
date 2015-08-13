/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem7 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null) {
                return right;
            }
            else {
                if(right == null) {
                    return left;
                }
                else {
                    return root;
                }
            }
        }
    }

    //Key points is to understand the fact that if left and right both != null, we should return root
    public static void main(String[] args) {

    }
}
