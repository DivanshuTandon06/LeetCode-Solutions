class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long product = 1; 
            for (int j = i; j < n; j++) {
                product *= nums[j];
                if (product < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}
