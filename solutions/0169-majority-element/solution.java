import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshold = nums.length / 2;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // 1. Update the frequency count in the map
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            
            // 2. Check if this element has crossed the majority threshold
            if (map.get(num) > threshold) {
                return num;
            }
        }
        
        // Fallback return statement (though the problem guarantees a majority element always exists)
        return -1;
    }
}
