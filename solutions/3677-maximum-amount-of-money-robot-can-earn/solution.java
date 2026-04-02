class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        
        // dp[i][j][k] -> max money at (i, j) with k neutralizations used
        int[][][] dp = new int[m][n][3];
        
        // Initialize with a very small value to represent unreachable/unprocessed states
        // Using -1e9 because the total coins could be negative
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE / 2; 
                }
            }
        }

        // Base case: Starting cell (0, 0)
        dp[0][0][0] = coins[0][0]; // No neutralization used
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // Used 1 neutralization at the start
            dp[0][0][2] = 0; // Technically could use 2, but 1 is enough to make it 0
        } else {
            dp[0][0][1] = coins[0][0];
            dp[0][0][2] = coins[0][0];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                for (int k = 0; k < 3; k++) {
                    // Get max from top or left for current 'k'
                    int prevMax = Integer.MIN_VALUE / 2;
                    if (i > 0) prevMax = Math.max(prevMax, dp[i - 1][j][k]);
                    if (j > 0) prevMax = Math.max(prevMax, dp[i][j - 1][k]);

                    // Option 1: Take the current cell value (always available)
                    dp[i][j][k] = Math.max(dp[i][j][k], prevMax + coins[i][j]);

                    // Option 2: Neutralize if it's a robber and we have k > 0
                    if (coins[i][j] < 0 && k > 0) {
                        int prevMaxLowerK = Integer.MIN_VALUE / 2;
                        if (i > 0) prevMaxLowerK = Math.max(prevMaxLowerK, dp[i - 1][j][k - 1]);
                        if (j > 0) prevMaxLowerK = Math.max(prevMaxLowerK, dp[i][j - 1][k - 1]);
                        
                        dp[i][j][k] = Math.max(dp[i][j][k], prevMaxLowerK);
                    }
                }
            }
        }

        // The answer is the maximum of having used 0, 1, or 2 neutralizations at the end cell
        return Math.max(dp[m - 1][n - 1][0], Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
    }
}
