import java.util.HashMap;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // Map to store <Remainder, Frequency>
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        
        // Base case: One prefix sum of 0 exists before the array starts
        remainderMap.put(0, 1);
        
        int prefixSum = 0;
        int count = 0;
        
        for (int num : nums) {
            prefixSum += num;
            
            // Calculate the remainder
            int rem = prefixSum % k;
            
            // Handle negative remainders to keep them strictly positive
            if (rem < 0) {
                rem += k;
            }
            
            // If this remainder exists in the map, it means we found valid subarrays
            if (remainderMap.containsKey(rem)) {
                count += remainderMap.get(rem);
            }
            
            // Update the frequency of the current remainder in the map
            remainderMap.put(rem, remainderMap.getOrDefault(rem, 0) + 1);
        }
        
        return count;
    }
}
