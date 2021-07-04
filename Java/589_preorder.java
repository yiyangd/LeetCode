//Solution 1 - Iteration
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
public List<Integer> preorder(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) return output;

    stack.add(root);
    while (!stack.isEmpty()) {
        Node node = stack.pollLast();
        output.add(node.val);
        Collections.reverse(node.children);
        for (Node item : node.children) {
            stack.add(item);
        }
    }
    return output;
}
```
//Time Complexity: O(n)  
//Space Complexity: O(n)
//--------------------------------------------------------------
//Solution 2 - Recursion
public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<Integer>();
    preorder_recur(root, res);
    return res;
}
public void preorder_recur(Node root, List<Integer> res){
    if (root == null) return;
    res.add(root.val);
    for (Node child : root.children){
        preorder_recur(child,res);
    }
}
//Time Complexity: O(n)  
//Space Complexity: O(n)
