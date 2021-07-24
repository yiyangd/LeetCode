//Solution 1 - DFS

public boolean canReach(int[] arr, int start) {
    if (start >= 0 && start < arr.length && arr[start] >= 0) {
        if (arr[start] == 0) return true;
        // mark negative as visited and still can be used in following recursion
        arr[start] = -arr[start];
        return canReach(arr,start-arr[start]) || canReach(arr,start+arr[start]);
    }
    return false;
}
/*
Time Complexity: O(n)
Space Complexity: O(n) for recursion stack
*/

//Solution 2 - BFS
public boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
        int idx = queue.remove();
        if (arr[idx] == 0) return true;
        if (arr[idx] > 0) {
            if (idx + arr[idx] < arr.length) queue.add(idx+arr[idx]);
            if (idx - arr[idx] >= 0) queue.add(idx-arr[idx]);
            arr[idx] = -1;
        }
    }
    return false;
}
/*
Time Complexity: O(n)
Space Complexity: O(n) for `queue`
*/
