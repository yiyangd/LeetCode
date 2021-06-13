
//Solution 1 - Iteration
public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode nextTemp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = nextTemp;
    }
    return prev;
}
// Time complexity : $O(N)$   
// Space complexity : $O(1)$ 


//Solution 2 - Recursion
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
}
// Time complexity : $O(N)$  
// Space complexity : $O(N)$ for recursive stack
