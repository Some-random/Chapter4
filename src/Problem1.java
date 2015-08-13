/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int dfsHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            int leftHeight = dfsHeight(root.left);
            int rightHeight = dfsHeight(root.right);
            if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    //This is the O(n) solution that does the check on the recursion down to leafs rather than the O(nlgn) solution that
    // computes height every time
    public static void main(String[] args) {

    }
}
