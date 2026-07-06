class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            // Determine which side is the bottleneck
            if (height[left] < height[right]) {
                // If current bar is taller than leftMax, update leftMax
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Otherwise, add the trapped water
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                // If current bar is taller than rightMax, update rightMax
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Otherwise, add the trapped water
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        
        return totalWater;
    }
}
