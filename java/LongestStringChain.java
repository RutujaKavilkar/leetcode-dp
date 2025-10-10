
 import java.util.*;

public class LongestStringChain {

    // Check if word1 is a predecessor of word2
    private static boolean checkPossible(String s1, String s2) {
        if (s1.length() + 1 != s2.length()) return false;

        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;  // skip one character in longer string
            }
        }

        // valid if all chars of s1 matched
        return i == s1.length();
    }

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Step 1: Sort by length
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // every word is a chain of length 1
        int maxi = 1;

        // Step 2: Compute LIS-like DP
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (checkPossible(words[prev], words[i]) && dp[i] < dp[prev] + 1) {
                    dp[i] = dp[prev] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

    // ---------- Test ----------
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println("✅ Longest String Chain Length: " + longestStrChain(words));
    }
}


