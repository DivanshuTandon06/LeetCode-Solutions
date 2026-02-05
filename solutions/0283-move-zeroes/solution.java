class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0 ;
        int j = 1;
        while(i < nums.length-1)
        {
            
            if( j == nums.length ) break;
            if(nums[i] !=0 ) 
            {
                i++;
                j++;
                continue;
            }
            if(nums[i] == 0 && nums[j] !=0 )
            {
                nums[i] = nums[j];
                nums[j] =0;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        
    }
}
