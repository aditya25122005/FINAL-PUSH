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
        PriorityQueue<ListNode>  pq = new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(int i=0;i<lists.length;i++){
            ListNode ln = lists[i];
            if(ln!=null){
                pq.add(ln);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(!pq.isEmpty()){
            ListNode rm = pq.poll();
            ptr.next = rm;
            ptr = ptr.next;
            if(rm.next!=null){
                pq.add(rm.next);
            }
        }
        return dummy.next;
    }
}