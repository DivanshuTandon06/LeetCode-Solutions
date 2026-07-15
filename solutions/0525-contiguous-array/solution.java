import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store <Prefix Sum, First Index Seen>
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        // Base case: A sum of 0 exists at an imaginary index before the array
        sumMap.put(0, -1);
        
        int maxLength = 0;
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, and 1 as 1
            if (nums[i] == 1) {
                runningSum += 1;
            } else {
                runningSum -= 1;
            }
            
            // If we've seen this sum before, we found a subarray that nets to 0
            if (sumMap.containsKey(runningSum)) {
                int previousIndex = sumMap.get(runningSum);
                int currentLength = i - previousIndex;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // ONLY add it to the map if we haven't seen it yet.
                // We want to keep the earliest index to maximize the subarray length.
                sumMap.put(runningSum, i);
            }
        }
        
        return maxLength;
    }
}
