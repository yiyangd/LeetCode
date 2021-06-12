// Solution 1 - Iteration
public ListNode removeElements(ListNode head, int val) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null) {
        if (temp.next.val == val) {
            temp.next = temp.next.next;
        } else {
            temp = temp.next;
        }
    }
    return dummyHead.next;
}
```
//Time complexity : $O(N)$   
//Space complexity : $O(1)$ 


//Solution 2 - Recursive
public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
        return head;
    }
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
}
//Time complexity : $O(N)$  
//Space complexity : $O(N)$ for recursive stack
