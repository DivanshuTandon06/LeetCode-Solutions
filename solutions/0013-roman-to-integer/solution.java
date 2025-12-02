class Solution {
    public int romanToInt(String s) {
       int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Get value of current symbol
            int s1 = getValue(s.charAt(i));
            
            // Look ahead to the next symbol (if we aren't at the end)
            if (i + 1 < s.length()) {
                int s2 = getValue(s.charAt(i + 1));
                
                // Compare current with next
                if (s1 >= s2) {
                    total = total + s1;
                } else {
                    total = total - s1; // Subtraction case (e.g., IV or IX)
                }
            } else {
                // If it's the last character, always add it
                total = total + s1;
            }
        }
        return total;
    }

    // Helper method to get the value of the Roman character
    private int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
