class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
         int n= nums.size();
         int a=0;
         int b=0;
         for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                     vector<int> v;
                      v.push_back(i);
                      v.push_back(j);
                      return v;
                }
            }
         }
        
         return {};
    }
};
