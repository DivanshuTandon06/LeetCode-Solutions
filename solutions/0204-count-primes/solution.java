class Solution {
    public int countPrimes(int n) {
        if(n <= 1 ) return 0;
        int [] prime = new int[n];
        Arrays.fill(prime,1);
        prime[0] = 0;
        prime[1] = 0;
        for(int i = 0 ; i*i <=n ;i++ ) {
            if(prime [i] ==1) {
                for(int j = i*i ;j<n ;j=j+i) {
                    prime[j] = 0;
                }
            }
        }
        int count = 0; 
        for(int i =0 ; i<n ;i++){
            if(prime[i] ==1) count++;
        }
        return count;
        
    }
}
