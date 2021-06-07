//Solution 1 - Hash Table
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while (head != null) {
        if (nodesSeen.contains(head)) {
            return true;
        }
        nodesSeen.add(head);
        head = head.next;
    }
    return false;
}
//Time complexity : $O(N)$.    
//Space complexity : $O(N)$ for Hash Table

//Solution 2 - Fast-Slow Pointers
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
//Time complexity : $O(N)$.    
//Space complexity : $O(1)$. 
