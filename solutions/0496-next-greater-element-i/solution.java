class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int i = 0;
        int[] arr = new int[nums1.length];
        while(i < nums1.length)
        {
            int element = nums1[i];
            int elementindex = 0;
            for(int j = 0 ; j < nums2.length ;j++)
            {
                if(nums2[j]== element)
                {
                    elementindex = j;
                    break;
                }
            }
            for(int k = elementindex ; k < nums2.length ; k++)
            {
                if(nums2[k]  > element)
                {
                    arr[i] = nums2[k];
                    break;
                }
                else{
                    arr[i] = -1;
                }
            }
            i++;
        }
        return arr;
        
    }
}
