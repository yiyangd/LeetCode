//Solution 1 - Recursion

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    postorder(root, res);
    return res;
}

public void postorder(TreeNode root, List<Integer> res) {
    if (root == null) return;
    
    postorder(root.left, res);
    postorder(root.right, res);
    res.add(root.val);
}
//Time Complexity: O(n)  
//Space Complexity: O(n) 


//Solution 2 - Iteration (hard)
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) return res;
    
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode prev = null;
    while (root != null || !stack.isEmpty()) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (root.right == null || root.right == prev) {
            res.add(root.val);
            prev = root;
            root = null;
        } else {
            stack.push(root);
            root = root.right;
        }
    }
    return res;
}
//Time Complexity: O(n)  
//Space Complexity: O(n) 
