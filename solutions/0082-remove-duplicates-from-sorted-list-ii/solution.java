class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1. Count frequencies using LinkedHashMap to preserve input order
        Map<Integer, Integer> map = new LinkedHashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        // 2. Rebuild the list using a dummy node
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // Only include values that appeared exactly once
            if (entry.getValue() == 1) {
                tail.next = new ListNode(entry.getKey());
                tail = tail.next;
            }
        }
        
        return dummy.next;
    }
}
