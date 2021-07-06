//Solution 1 - Iteration

public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    List<Node> previousLayer = Arrays.asList(root);

    while (!previousLayer.isEmpty()) {
        List<Node> currentLayer = new ArrayList<>();
        List<Integer> previousVals = new ArrayList<>();
        for (Node node : previousLayer) {
            previousVals.add(node.val);
            currentLayer.addAll(node.children);
        }
        result.add(previousVals);
        previousLayer = currentLayer;
    }
    return result;
}
//Time Complexity: O(n)  
//Space Complexity: O(n)

//Solution 2 - Recursion
public List<List<Integer>> levelOrder(Node root){
    List<List<Integer>> levels = new ArrayList<>();
    if (root!=null) traverseNode(root,0,levels);
    return levels;
}
private void traverseNode(Node node, int level, List<List<Integer>>levels){
    if (levels.size()<=level)
        levels.add(new ArrayList<>());
    levels.get(level).add(node.val);
    for (Node child:node.children){
        traverseNode(child,level+1,levels);
    }
}
//Time Complexity: O(n)  
//Space Complexity: $O(\log(n))$ average case and O(n) worst case. 
// - The space used is on the runtime stack.
