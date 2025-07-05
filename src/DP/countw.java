package DP;

public class countw {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) < 0 || (sum - target) % 2 != 0) return 0;

        int t = (sum - target) / 2;
        int[][] dp = new int[n][t + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (nums[0] == 0) {
            dp[0][0] = 2; // +0 and -0 are both valid
        } else if (nums[0] <= t) {
            dp[0][nums[0]] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                int nt = dp[i - 1][j];
                int t1 = (nums[i] > j) ? 0 : dp[i - 1][j - nums[i]];
                dp[i][j] = nt + t1;
            }
        }

        return dp[n - 1][t];
    }
}

