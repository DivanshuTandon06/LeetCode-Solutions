class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[2*n];
            int x = 0 , y = n , j= 0;
            while(x <n && y <2*n)
            {
                ans[j++]=nums[x];
                ans[j++] = nums[y];
                x++;
                y++;
            }
            return ans;
        
    }
}
