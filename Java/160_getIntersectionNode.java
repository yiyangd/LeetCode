
//Solution 1 - Hash Table
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> nodesInB = new HashSet<ListNode>();
    while (headB != null) {
        nodesInB.add(headB); 
        headB = headB.next;
    }
    while (headA != null) {
        if (nodesInB.contains(headA)) {
            return headA;
        }
        headA = headA.next;
    }
    return null;
}
//Time complexity : $O(M+N)$
//Space complexity : $O(M)$ as we are storing M nodes from list B into a hash table

//Solution 2 - Two Pointers
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
        // First Iteration for Right Alignment
        // Second Iteration to find Intersection or both reach null
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA; // == pB 
}
//Time complexity : $O(M+N)$  
//Space complexity : $O(1)$ 

