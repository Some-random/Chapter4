import java.util.Stack;

/**
 * Created by Bob_JIANG on 8/14/2015.
 */
public class Problem6 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class BSTIterator {
        TreeNode temp;
        Stack<TreeNode> ST;

        public BSTIterator(TreeNode root) {
            temp = root;
            ST = new Stack<>();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return (temp != null || !ST.empty());
        }

        /** @return the next smallest number */
        public int next() {
            while(temp != null || !ST.empty()) {
                if(temp != null) {
                    while(temp != null) {
                        ST.push(temp);
                        temp = temp.left;
                    }
                }
                else {
                    temp = ST.pop();
                    int tempvalue = temp.val;
                    temp = temp.right;
                    return tempvalue;
                }
            }
            //This return statement is only here for the complier cuz it will always return before it breaks the loop
            return 0;
        }
    }

    //Make use of stack-based inorder traversal, notice when do we assign current node to its right child and when do
    // we just go straight to the left
    public static void main(String[] args) {

    }
}
