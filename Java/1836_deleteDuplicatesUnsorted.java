//Solution - HashMap
public ListNode deleteDuplicatesUnsorted(ListNode head) {
    HashMap<Integer, Integer> repeatedNodes = new HashMap<>();
    ListNode tempHead = new ListNode(); // temporary node as a temp head in case the head is one of the nodes needs to be deleted or head is null
    tempHead.next = head; // set temporary node next to head
    ListNode curr = tempHead.next;
    while(curr!=null) {
        repeatedNodes.put(curr.val, repeatedNodes.getOrDefault(curr.val, 0)+1); // count the repeated node values
        curr=curr.next;
    }

    curr = tempHead;
    while(curr !=null && curr.next!=null) {
        if(repeatedNodes.get(curr.next.val)>1) { 
            curr.next = curr.next.next;
        } else{
            curr = curr.next;
        }
    }

    return tempHead.next; // we should return tempHead.next but not tempHead as tempHead is a dummy node we created

//Time complexity : $O(N)$.    
 // Space complexity : $O(N)$ for hash
