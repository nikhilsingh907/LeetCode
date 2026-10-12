/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(second);
        return merge(left,right);
    }

    private ListNode merge(ListNode Left, ListNode Right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(Left != null && Right != null){
            if(Left.val <= Right.val){ 
              curr.next = Left;
              Left =Left.next;
            }else{
                curr.next = Right;
                Right = Right.next;
            }
            curr = curr.next;
        }
        if(Left != null)
            curr.next = Left;
        if(Right != null)
            curr.next = Right;    
        return dummy.next;    
        
    }
}