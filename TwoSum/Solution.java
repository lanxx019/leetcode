import java.util.*;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return findTwoSum(numbers, target);
    }

    /**
     * Use {@link HashMap} to remember all the numbers in the array.
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] findTwoSum(final int[] numbers, final int target) {
        final int[] result = new int[2];
        final HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            indexMap.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            final int lookingFor = target - numbers[i];
            /**
             * If target is 4 and the number we are looking for is 2, we need to make sure we actaully have two 2's, if
             * we we only have one 2, we should not consider it as an answer.
             */
            if (indexMap.containsKey(lookingFor) && indexMap.get(lookingFor) - 1 != i) {
                final int anotherIndex = indexMap.get(lookingFor);
                if (anotherIndex > i) {
                    result[0] = i + 1;
                    result[1] = anotherIndex;
                } else {
                    result[0] = anotherIndex;
                    result[1] = i + 1;
                }
                return result;
            }
        }

        throw new IllegalStateException("Expecting at least one matched result");
    }
}

