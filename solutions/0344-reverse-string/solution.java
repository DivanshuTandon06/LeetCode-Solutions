class Solution {
    public void reverseString(char[] s) {
        Stack<Character> st = new Stack<>();
        for(int a = 0 ; a<s.length;a++){
            st.push(s[a]);
        }
         for(int a = 0 ; a<s.length;a++){
            s[a] = st.pop();
        }

    }
}
