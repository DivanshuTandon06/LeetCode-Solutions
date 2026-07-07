class Solution {
    public String convert(String s, int numRows) {
        // Edge case: If 1 row or string length is less than rows, no change
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Create a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // If we hit the top or bottom, reverse the direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to the next row based on direction
            currentRow += goingDown ? 1 : -1;
        }

        // Build the final result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
