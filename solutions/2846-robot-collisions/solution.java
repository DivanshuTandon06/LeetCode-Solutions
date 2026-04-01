import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // 1. Sort indices based on their positions
        Arrays.sort(indices, (a, b) -> Integer.compare(positions[a], positions[b]));

        Deque<Integer> stack = new ArrayDeque<>();

        for (int currentIndex : indices) {
            if (directions.charAt(currentIndex) == 'R') {
                // If moving Right, just add to stack (it won't hit anything to its left)
                stack.push(currentIndex);
            } else {
                // If moving Left, check for collisions with robots in the stack moving Right
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    int topIndex = stack.peek();
                    
                    if (healths[currentIndex] > healths[topIndex]) {
                        // Current (L) wins: R is destroyed, L loses 1 health
                        healths[topIndex] = 0;
                        healths[currentIndex] -= 1;
                        stack.pop();
                    } else if (healths[currentIndex] < healths[topIndex]) {
                        // Top (R) wins: L is destroyed, R loses 1 health
                        healths[currentIndex] = 0;
                        healths[topIndex] -= 1;
                    } else {
                        // Both have equal health: both destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                        stack.pop();
                    }
                }
            }
        }

        // 2. Collect surviving healths in original order
        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) {
                result.add(h);
            }
        }
        return result;
    }
}
