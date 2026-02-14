class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
         int max = 0; 
        for( int t = 0 ; t <nums1.length ;t++)
        {
            int index = 0;
            for(int k = 0 ; k < nums2.length ;k++)
            {
                if(nums1[t] == nums2[k])
                {
                    max = nums2[k];
                    index = k; 
                }
            }
            for(int y = index ; y < nums2.length ; y++)
            {
                if(nums2[y] > max)
                {
                max = nums2[y];
                break;
                }
            }

            if(max == nums2[index])
            {
                nums1[t] = -1;
            }
            else
            {
                nums1[t] = max;
            }
        }
        return nums1;
        

        
    }
}
