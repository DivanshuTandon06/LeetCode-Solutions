class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int count=-1;
        String str = " ";
        if(!s.contains(str)) return s.length();
        for(int i=s.length()-1 ; i >= 0 ;i--)
        {
            count++;
            if(s.charAt(i)== ' ') return count;
        }
        return count;
    }
}
