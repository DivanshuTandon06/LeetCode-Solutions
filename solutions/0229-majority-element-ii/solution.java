class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int x = (nums.length )/3;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > x) 
            list.add(key);
        }
        return list;
        
    }
}
