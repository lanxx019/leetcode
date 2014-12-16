import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charIndexMap = new HashMap<Character, Integer>();
        int result = 1;
        int firstIndex = 0;
        int secondIndex = 1;
        // Do not forget to initialize this condition.
        charIndexMap.put(s.charAt(0), 0);
        while (secondIndex < s.length()) {
            final Character c = s.charAt(secondIndex);
            if (charIndexMap.containsKey(c)) {
                final int index = charIndexMap.get(c);
                if (index >= firstIndex) {
                    // If we have seen character c before and c is on the right hand side of firstIndex, then we have a
                    // repeated character and we need to update firstIndex
                    firstIndex = index + 1;
                }
            }
            charIndexMap.put(c, secondIndex);
            // Invariant: s[firstIndex, secondIndex] does not contain any repeated characters.
            result = Math.max(result, secondIndex - firstIndex + 1);
            secondIndex++;
        }

        return result;
    }
}

