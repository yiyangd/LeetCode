//Solution 1 - Recursion

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    level_order(root,0,levels);
    return levels;
}
public void level_order(TreeNode node, int level, List<List<Integer>> levels){
    if (node == null) return;
    if (levels.size() == level)
        levels.add(new ArrayList<Integer>());
    
    levels.get(level).add(node.val);
    
    if (node.left != null)
        level_order(node.left, level+1, levels);
    if (node.right != null)
        level_order(node.right, level+1, levels);
}
//Time Complexity: O(n)  
//Space Complexity: O(n)


//Solution 2 - Iteration
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if (root == null) return levels;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //https://stackoverflow.com/questions/38591371/java-linkedlist-class-as-stack-and-queueshttps://stackoverflow.com/questions/38591371/java-linkedlist-class-as-stack-and-queues
    queue.add(root);
    while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<Integer>();
        int currentLevelSize = queue.size();
        for (int i = 0; i < currentLevelSize; ++i) {
            TreeNode node = queue.remove();
            level.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        levels.add(level);
    }
    return levels;
}
//Time Complexity: O(n)  
//Space Complexity: O(n)

