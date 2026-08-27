class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Count matching prefix requirements
        int[] targetFreq = new int[26];
        int matchLength = -1;
        
        // Find how far s can match target from left to right
        for (int i = 0; i < n; i++) {
            targetFreq[target.charAt(i) - 'a']++;
        }
        
        // Try each split point i from n-1 down to 0
        // i represents the index where the constructed string becomes strictly greater than target
        for (int i = n - 1; i >= 0; i--) {
            // Remove target[i] from prefix count requirement
            targetFreq[target.charAt(i) - 'a']--;
            
            // Check if frequency of target[0...i-1] is valid (subset of freq)
            if (isValid(freq, targetFreq)) {
                // Find smallest char strictly greater than target[i] available in remaining pool
                int targetChar = target.charAt(i) - 'a';
                int nextChar = -1;
                
                for (int c = targetChar + 1; c < 26; c++) {
                    if (freq[c] - targetFreq[c] > 0) {
                        nextChar = c;
                        break;
                    }
                }
                
                if (nextChar != -1) {
                    // We found the best split point!
                    StringBuilder result = new StringBuilder();
                    
                    // 1. Add prefix matching target[0...i-1]
                    result.append(target.substring(0, i));
                    
                    // 2. Add nextChar at index i
                    result.append((char) ('a' + nextChar));
                    
                    // 3. Update remaining frequencies
                    int[] remaining = new int[26];
                    for (int c = 0; c < 26; c++) {
                        remaining[c] = freq[c] - targetFreq[c];
                    }
                    remaining[nextChar]--;
                    
                    // 4. Fill remaining positions in smallest (ascending) order
                    for (int c = 0; c < 26; c++) {
                        while (remaining[c] > 0) {
                            result.append((char) ('a' + c));
                            remaining[c]--;
                        }
                    }
                    
                    return result.toString();
                }
            }
        }
        
        return "";
    }
    
    private boolean isValid(int[] freq, int[] targetFreq) {
        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] > freq[i]) {
                return false;
            }
        }
        return true;
    }
}
