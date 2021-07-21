//Solution - BFS & Hash

public int openLock(String[] deadends, String target) {
    HashSet<String> deadset = new HashSet();
    for (String d:deadends) deadset.add(d);
    if (deadset.contains("0000")) return -1;

    Queue<String> queue = new LinkedList();
    queue.offer("0000");
    Set<String> visited = new HashSet();
    visited.add("0000");

    int depth = 0;
    while (!queue.isEmpty()) {
        int size = queue.size(); // the size will vary in for loop
        for (int i = 0; i < size; i++) {
            String node = queue.poll();
            if (node.equals(target)) {
                return depth; // return 0 if the target is "0000"
            }

            for (String newnode : getNewNodes(node)) {
                if (!visited.contains(newnode) && !deadset.contains(newnode)) {
                    queue.add(newnode);
                    visited.add(newnode);
                }
            }
        }
        depth++;
    }
    return -1;
}
private List<String> getNewNodes(String node) {
    List<String> newnodes = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
        for (int k = -1; k <= 1; k += 2) {
            char[] newNode = new char[4];

            String turned = (((node.charAt(i)-'0') + k + 10) % 10) + "";
            newNode[i] = turned.charAt(0);

            for (int j = 0; j < 4; j++) {
                if (j != i) newNode[j] = node.charAt(j);
            }
            newnodes.add(new String(newNode));
        }
    }
    return newnodes;
}
/*
Time Complexity: $O(A^N \times N^2 + D)$
- A is the base of numbers ( = 10)， N is the number of digits in the lock ( = 4), D is the size of `deadends` 

Space Complexity: O(A^N \times N + D) to store `queue` and `hashset` 
*/
