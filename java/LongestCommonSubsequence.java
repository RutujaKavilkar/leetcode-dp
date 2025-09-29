import java.util.Arrays;

public class LongestCommonSubsequence {
    int[][] dp;  // memoization table
    
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1); // initialize with -1
        }
        
        return f(n - 1, m - 1, text1, text2);
    }
    
    private int f(int idx1, int idx2, String s1, String s2) {
        if (idx1 < 0 || idx2 < 0) return 0;
        
        if (dp[idx1][idx2] != -1) return dp[idx1][idx2]; // check cache
        
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + f(idx1 - 1, idx2 - 1, s1, s2);
        }
        
        return dp[idx1][idx2] = Math.max(
            f(idx1 - 1, idx2, s1, s2), 
            f(idx1, idx2 - 1, s1, s2)
        );
    }
}


