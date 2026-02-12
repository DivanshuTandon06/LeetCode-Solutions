class Solution {
    public double myPow(double x, int n) {
        long N = n;   // convert to long to handle Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1;
        
        while (N > 0) {
            if (N % 2 == 1) {   // if power is odd
                result *= x;
            }
            x *= x;      // square the base
            N /= 2;      // divide power by 2
        }
        
        return result;
    }
}

