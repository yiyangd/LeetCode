/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// Solution 1 - Iteration
// Time Complexity: O(n)
// Space Compexity: O(n)
public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList <TreeNode> stack = new LinkedList<> ();
    LinkedList <Integer> output = new LinkedList<> ();

    if(root==null) return output;
    stack.add(root);

    while(!stack.isEmpty()){
        TreeNode node = stack.pollLast();
        output.add(node.val);
        if(node.right!=null) stack.add(node.right); //先入后出
        if(node.left!=null) stack.add(node.left);   //后入先出
    }
    return output;
}

// Solution 2 - Recursion
// Time Complexity: O(n)
// Space Compexity: O(n)
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    preorder(root, res);
    return res;
}

public void preorder(TreeNode root, List<Integer> res) {
    if (root == null) {
        return;
    }
    res.add(root.val);
    preorder(root.left, res);
    preorder(root.right, res);
}
