import CtCILibrary.CtCILibrary.AssortedMethods;
import CtCILibrary.CtCILibrary.TreeNode;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem8 {

    public static String inorderPath(TreeNode root) {
        String temp = "";
        if(root.left != null) {
            temp += '(';
            temp += inorderPath(root.left);
            temp += ')';
        }
        temp += root.data;
        if(root.right != null) {
            temp += '(';
            temp += inorderPath(root.right);
            temp += ')';
        }
        return temp;
    }


    //The answer given in solution does too much redundant work. The solution I use transforms binary tree to hashString
    // with parentheses. This way I can make sure it's a one on one mapping between tree and String and then using find
    // String function makes the execution a lot faster
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] array2 = {2, 4, 5, 8, 9, 10, 11};

        TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

        String t1s = inorderPath(t1);
        String t2s = inorderPath(t2);

        if (t1s.contains(t2s))
            System.out.println("t2 is a subtree of t1");
        else
            System.out.println("t2 is not a subtree of t1");

        // t4 is not a subtree of t3
        int[] array3 = {1, 2, 3};
        TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
        TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

        String t3s = inorderPath(t3);
        String t4s = inorderPath(t4);

        if (t3s.contains(t4s))
            System.out.println("t4 is a subtree of t3");
        else
            System.out.println("t4 is not a subtree of t3");
    }
}
