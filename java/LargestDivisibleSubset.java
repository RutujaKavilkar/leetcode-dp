 import java.util.*;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // sorting helps divisibility checks
        int n = nums.length;

        // dp[ind][prev+1] will store the subset (not just length!)
        List<Integer>[][] dp = new ArrayList[n][n+1];

        return helper(0, -1, nums, dp);
    }

    private List<Integer> helper(int ind, int prev, int[] nums, List<Integer>[][] dp) {
        if (ind == nums.length) {
            return new ArrayList<>(); // empty subset
        }

        if (dp[ind][prev+1] != null) return dp[ind][prev+1];

        // Case 1: Not take current element
        List<Integer> notTake = helper(ind + 1, prev, nums, dp);

        // Case 2: Take current element (if divisible with prev)
        List<Integer> take = new ArrayList<>();
        if (prev == -1 || nums[ind] % nums[prev] == 0) {
            take = new ArrayList<>();
            take.add(nums[ind]);
            take.addAll(helper(ind + 1, ind, nums, dp));
        }

        // Choose the longer subset
        if (take.size() > notTake.size()) {
            dp[ind][prev+1] = take;
        } else {
            dp[ind][prev+1] = notTake;
        }

        return dp[ind][prev+1];
    }
}


