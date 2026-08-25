class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currsum = 0;
        int minlen = Integer.MAX_VALUE;

        for(int right = 0 ; right <nums.length ; right++) {
            currsum += nums[right];

            while(currsum >=target) {
                minlen = Math.min(minlen , right -left +1);
                currsum -= nums[left];
                left++;
            }  
        }
        return minlen == Integer.MAX_VALUE?0:minlen ;
        
    }
}
