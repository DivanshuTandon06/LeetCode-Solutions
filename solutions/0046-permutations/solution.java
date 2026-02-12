class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, new ArrayList<>(), used);
        return result;
    }
    
    private void backtrack(int[] nums, List<List<Integer>> result, 
                           List<Integer> path, boolean[] used) {
        
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            used[i] = true;
            path.add(nums[i]);
            
            backtrack(nums, result, path, used);
            
            path.remove(path.size() - 1);  // backtrack
            used[i] = false;
        }
    }
}

