class Solution {
    public int reverse(int x) {
        int c = x;

        int y= 0;
        while(c!=0){
            int pop = c%10;
            c= c/10;
            if (y > Integer.MAX_VALUE / 10 || (y == Integer.MAX_VALUE / 10 && pop > 7)) 
                return 0;
            if (y < Integer.MIN_VALUE / 10 || (y == Integer.MIN_VALUE / 10 && pop < -8)) 
                return 0;
                
            y = y * 10 + pop;

        }
        return y;
    }
}
