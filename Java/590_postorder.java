//Solution 1 - Iteration
public List<Integer> postorder(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) return output;

    stack.add(root);
    while (!stack.isEmpty()) {
        Node node = stack.pollLast();
        output.addFirst(node.val);
        for (Node child : node.children) {
            if (child != null) stack.add(child);    
        }
    }
    return output;
}
//Time Complexity: O(n)  
//Space Complexity: O(n)

//Solution 2 - Recursion
public List<Integer> postorder(Node root) {
    List<Integer> res = new ArrayList<Integer>();
    post_ord(root,res);
    return res;
}
public void post_ord(Node root, List<Integer> res){
    if (root == null) return;
    for (Node child: root.children) {
        post_ord(child,res);
    }
    res.add(root.val);
}
//Time Complexity: O(n)  
//Space Complexity: O(n)
