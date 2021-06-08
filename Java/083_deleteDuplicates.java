// Solution 1
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.next.val == current.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
//Time complexity : $O(N)$.    
//Space complexity : $O(1)$. 

//Solution 2 - Recursive
public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return head;
    head.next = deleteDuplicates(head.next);
    return (head.next != null && head.val == head.next.val) ? head.next : head;
}
