import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static ArrayList<LinkedList<TreeNode>> levelOrder(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> LLI = new ArrayList<>();
        if(root == null) {
            return LLI;
        }
        Queue<TreeNode> QT = new LinkedList<>();
        QT.add(root);
        while(!QT.isEmpty()) {
            LinkedList<TreeNode> tempLLT = new LinkedList<>();
            Queue<TreeNode> tempQT = new LinkedList<>();
            while(!QT.isEmpty()) {
                TreeNode tempTN = QT.poll();
                if(tempTN.left != null) {
                    tempQT.add(tempTN.left);
                }
                if(tempTN.right != null) {
                    tempQT.add(tempTN.right);
                }
                tempLLT.add(tempTN);
            }
            QT = tempQT;
            LLI.add(tempLLT);
        }
        return LLI;
    }

    //Notice how Java uses queue as a abstract class and the functions calls on queue here
    public static void main(String[] args) {

    }
}
