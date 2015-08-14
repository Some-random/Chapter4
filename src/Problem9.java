import CtCILibrary.CtCILibrary.TreeNode;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem9 {

    public static void findSum(TreeNode root, int level, int[] temp, int sum) {
        if(root == null) {
            return;
        }
        else {
            temp[level] = root.data;
            int tempvalue = 0;
            for(int i = level; i >= 0; i--) {
                tempvalue += temp[i];
                if(tempvalue == sum) {
                    for(int j = level; j >= 0; j--) {
                        System.out.print(temp[j] + " ");
                    }
                    System.out.println();
                }
            }
            findSum(root.left, level + 1, temp, sum);
            findSum(root.right, level + 1, temp, sum);
        }
    }

    public static int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        else {
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }


    //I'm not sure the answer given in offical solution is correct. It doesn't take care of cases where a path starts
    // at a left subtree and ends a right subtree. Other than that, the backtracking in this problem is kinda interesting.
    // Also notice we don't need to erase the "effect" of trail of backtracking in this problem.
    public static void main(String[] args) {
        CtCILibrary.CtCILibrary.TreeNode root = new CtCILibrary.CtCILibrary.TreeNode(5);
        root.left = new CtCILibrary.CtCILibrary.TreeNode(3);
        root.right = new CtCILibrary.CtCILibrary.TreeNode(1);
        root.left.left = new CtCILibrary.CtCILibrary.TreeNode(4);
        root.left.right = new CtCILibrary.CtCILibrary.TreeNode(8);
        root.right.left = new CtCILibrary.CtCILibrary.TreeNode(2);
        root.right.right = new CtCILibrary.CtCILibrary.TreeNode(6);

        int d = depth(root);
        int[] temp = new int[d];
        findSum(root, 0, temp, 8);

    }
}
