public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null, tail = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;
        int sum = n1 + n2 + carry;
        carry = sum / 10;

        if (head == null) {
            head = tail = new ListNode(sum % 10);
        } else {
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
        
    }
    if (carry > 0) tail.next = new ListNode(carry);
    // if (carry == 1) tail.next = new ListNode(1);
    
    return head;
}
//Time complexity : $O(\max(m, n))$. 
//- Assume that m and n represents the length of l1 and l2 respectively  

//Space complexity : $O(\max(m, n))$. 
//- The length of the new list is at most $\max(m,n) + 1$
