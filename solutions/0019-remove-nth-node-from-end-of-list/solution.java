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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       
        ListNode curr = head;
        int length =0;
        while(curr != null)
        {
            curr = curr.next;
            length++;
        }
         if(length == n) return head.next;
        int diff = length - n - 1;
        curr = head;
        for(int i = 0 ; i < diff ; i++)
        {
            curr = curr.next;
        }        
        curr.next = curr.next.next;
        return head;

    }
}
