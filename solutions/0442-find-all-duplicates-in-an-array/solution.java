// class Solution {
//     public List<Integer> findDuplicates(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         HashSet<Integer> set = new HashSet<>();
//         for(int i: nums) {
//             if(set.contains(i)) list.add(i);
//             set.add(i);
//         } 
//         return list;
//     }
// }

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return list;
    }
}
