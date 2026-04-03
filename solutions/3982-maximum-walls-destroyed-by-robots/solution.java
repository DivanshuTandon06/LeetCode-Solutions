import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[][] rData = new int[n][2];
        for (int i = 0; i < n; i++) {
            rData[i][0] = robots[i];
            rData[i][1] = distance[i];
        }
        
        // Step 1: Sort everything for linear processing and Binary Search
        Arrays.sort(rData, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(walls);

        long[][] dp = new long[n][2];

        // Base case: First robot
        // Left: covers [R0 - D0, R0] (nothing to its left to block it)
        dp[0][0] = countWalls(walls, (long)rData[0][0] - rData[0][1], (long)rData[0][0]);
        // Right: Only guarantees hitting a wall at its own position R0
        dp[0][1] = countWalls(walls, (long)rData[0][0], (long)rData[0][0]);

        for (int i = 1; i < n; i++) {
            long prevPos = rData[i - 1][0];
            long currPos = rData[i][0];
            int prevDist = rData[i - 1][1];
            int currDist = rData[i][1];
            long wallAtCurr = countWalls(walls, currPos, currPos);

            // --- State: Current Robot i fires Left (dp[i][0]) ---
            // If prev was Left: current only gets its left-reach limited by prevPos
            long onlyCurrLeft = countWalls(walls, Math.max(currPos - currDist, prevPos + 1), currPos);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][0] + onlyCurrLeft);

            // If prev was Right: both fire into the same gap; count the Union
            long unionCount = countUnion(walls, prevPos, currPos, prevDist, currDist);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + unionCount + wallAtCurr);

            // --- State: Current Robot i fires Right (dp[i][1]) ---
            // If prev was Left: gap is empty, only wall at current position is hit
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + wallAtCurr);

            // If prev was Right: only the previous robot's Right-reach hits the gap
            long onlyPrevRight = countWalls(walls, prevPos + 1, Math.min(prevPos + prevDist, currPos - 1));
            dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + onlyPrevRight + wallAtCurr);
        }

        // Final touch: If the last robot fired Right, add its reach to the infinity on the right
        long lastRightReach = countWalls(walls, (long)rData[n - 1][0] + 1, (long)rData[n - 1][0] + rData[n - 1][1]);
        
        return (int) Math.max(dp[n - 1][0], dp[n - 1][1] + lastRightReach);
    }

    // Helper: Binary Search to count walls in range [left, right]
    private long countWalls(int[] walls, long left, long right) {
        if (left > right) return 0;
        int lIdx = Arrays.binarySearch(walls, (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, left)));
        if (lIdx < 0) lIdx = -(lIdx + 1);
        
        int rIdx = Arrays.binarySearch(walls, (int) Math.max(Integer.MIN_VALUE, Math.min(Integer.MAX_VALUE, right)));
        if (rIdx < 0) rIdx = -(rIdx + 1) - 1;
        
        return Math.max(0, rIdx - lIdx + 1);
    }

    // Helper: Count unique walls in the union of (Prev firing Right) and (Curr firing Left)
    private long countUnion(int[] walls, long r1, long r2, int d1, int d2) {
        long end1 = Math.min(r2 - 1, r1 + d1);
        long start2 = Math.max(r1 + 1, r2 - d2);
        
        if (end1 >= start2) {
            // Overlapping or touching ranges: count entire gap
            return countWalls(walls, r1 + 1, r2 - 1);
        } else {
            // Disjoint ranges: sum them up
            return countWalls(walls, r1 + 1, end1) + countWalls(walls, start2, r2 - 1);
        }
    }
}
