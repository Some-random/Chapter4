import java.util.Arrays;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(0);
        if(nums.length == 0) {
            return null;
        }
        else if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        else {
            root = new TreeNode(nums[nums.length / 2]);
            int[] leftpart = Arrays.copyOfRange(nums, 0, nums.length / 2);
            int[] rightpart = Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length);
            TreeNode left = sortedArrayToBST(leftpart);
            TreeNode right = sortedArrayToBST(rightpart);
            root.left = left;
            root.right = right;
        }
        return root;
    }

    //Notice the Java function call to subarray, the last index is always one over!
    public static void main(String[] args) {

    }
}
