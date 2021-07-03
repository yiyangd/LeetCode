//Solution 1 - Recursion
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    inorder(root, res);
    return res;
}

public void inorder(TreeNode root, List<Integer> res) {
    if (root == null) return;
    
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
}
//Time Complexity: O(n)  
//Space Complexity: O(n) 

//Solution 2 - Iteration
public List < Integer > inorderTraversal(TreeNode root) {
    List < Integer > res = new ArrayList < > ();
    Stack < TreeNode > stack = new Stack < > ();
    TreeNode curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
    }
    return res;
}
//Time Complexity: O(n)  
//Space Complexity: O(n) 
