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
        if(head == null) return null;
        ListNode curr = head;
        boolean issorted = false;
        int smallest = head.val;
        int arr[] = new int[50000];
        int i = 0;
        while(curr != null){
            arr[i] = curr.val;
            curr = curr.next;
            i++;
        }
        curr = head;
       Arrays.sort(arr, 0, i);
       for (int j = 0; j < i; j++) {
            curr.val = arr[j];
            curr = curr.next;
        }
        return head;
        
    }
}
