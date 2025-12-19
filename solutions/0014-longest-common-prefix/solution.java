class Solution {
    public String longestCommonPrefix(String[] strs) {
        // String ans = "";
        // int n = strs.length;
        // if(strs==null) return ans;
        // if(n ==1) return strs[0];
        // int los=strs[0].length();

        // // this loop will check the length of smallest string
        // for(int k = 1 ; k < n; k++){
        //     if(strs[k].length()<=los) los = strs[k].length();
        // }
        // String a = strs[0];
        // // this loop will slice each char of first String till the length of the smallest string
        // for(int i = 0 ;i< los ; i++){
        //        char b =a.charAt(i);
        // // this loop will check  every word has character ( i )or not 
        // for(int j = 1 ; j<n ;j++){
          
        //     if (b!=strs[j].charAt(i)) return ans;
        // }
        // ans+=b;
        // }
        // return ans;

        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        char [] first = strs[0].toCharArray(); 
        char [] last = strs[strs.length- 1].toCharArray();
        for(int i = 0 ; i< first.length ;i++){
            if(first[i]!=last[i])
                break;
            ans.append(first[i]);
            }
        return ans.toString();
        
    }
}
