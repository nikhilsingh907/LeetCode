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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null)
             pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll(); //[]

            curr.next = node; // 1->1->2->2->3->4->4->5->6
            curr = curr.next;

            if(node.next != null)
            pq.offer(node.next); // 4,3.6,4,5
        }
        return dummy.next;
    }
}