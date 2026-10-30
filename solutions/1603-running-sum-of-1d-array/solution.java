class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int [] ps = new int[n];
        if(n > 0) {
            ps[0]=nums[0];
            for(int i= 1; i< n ;i++) {
                ps[i] =nums[i] +ps[i-1];
            }
            
        }
         return ps;
    }
}
