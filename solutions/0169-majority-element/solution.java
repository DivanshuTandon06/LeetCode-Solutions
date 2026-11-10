import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
    //    for(int i = 0 ; i< nums.length ;i++) {
    //     int count =0;
    //     for(int j = 0 ; j< nums.length ;j++) {
    //         if(nums[i] ==nums[j]) {
    //             count++;
    //         }
    //     }
    //     if(count > nums.length/2)
    //     return nums[i];
    //    }
    //    return -1;

    // HashMap<Integer,Integer> map = new HashMap<>();
    // int target = nums.length/2;
    // for(int i : nums) {
    //     int count = map.getOrDefault(i,0) +1;
    //     if(count > target)
    //     return i;
    //     map.put(i,count);
    // }
    // return -1;

    //boyer- moore algorithm
    int el = 0;
    int count =0; 
    for(int i = 0 ;i < nums.length ;i++) {
        if(count ==0) {
            el=nums[i];
            count =1;
        }
        else if (el == nums[i]) {
            count++;
        }
        else { //el != nums[i]
        count--;
        }
    }
    int count1 = 0;
    for(int i = 0 ; i< nums.length ;i++) {
        if(nums[i] == el) count1++;
    }
    if (count1 > nums.length/2) return el;
    return -1;
    }
}
