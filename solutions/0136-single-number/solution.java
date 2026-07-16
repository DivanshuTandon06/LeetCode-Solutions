// class Solution {
//     public int singleNumber(int[] nums) {
//         for (int i = 0; i < nums.length; i++) {
//             boolean hasDuplicate = false;
//             for (int j = 0; j < nums.length; j++) {
//                 if (i != j && nums[i] == nums[j]) {
//                     hasDuplicate = true;
//                     break; 
//                 }
//             }
//             if (!hasDuplicate) {
//                 return nums[i]; 
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i]; // XOR each element with the running result
        }
        
        return result;
    }
}
