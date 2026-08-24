class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // int n= nums.length;
        // int left = 0;
        // double max= -Double.MAX_VALUE;;
        // boolean found = false;

        // while(!found) {
        //     int right = left+k-1;
        //     double temp = 0 ;

        //     for(int i = left; i<=right;i++){
        //       temp +=  nums[i];
        //     }

        //     temp = temp/k;

        //     if(temp >= max) {
        //         max = temp;
        //     }

        //     if(right == n-1 ){ 
        //         found =true;
        //     }
        //     left++;
        // }

        // return max;
        // not working this approach for big testcases
        double sum = 0;
        // calculate first window size 
        for(int i = 0 ; i<k ;i++) {
            sum += nums[i];
        }
        double maxSum = sum ;
        // sliding window now 
        for(int i = k ; i< nums.length ; i++) {
            sum += nums[i];// added new element to prev sum 
            sum -= nums[i-k]; // removing the older element
            maxSum = Math.max(maxSum, sum);// checking that this window sum is greater than maxsum or not if not then for loop will run again checking next window until i reaches length of array
        }
        return maxSum/k;
    }
}
