class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        dp[0] = 0;

        int l_30 = 0;
        int l_7 = 0;
        for (int r = 1; r < dp.length; ++r) {
            while (l_30 < r && days[r - 1] - days[l_30] >= 30) {
                ++l_30;
            }
            while (l_7 < r && days[r - 1] - days[l_7] >= 7) {
                ++l_7;
            }
            dp[r] = Math.min(dp[l_30] + costs[2], 
                    Math.min(dp[l_7] + costs[1], 
                    dp[r - 1] + costs[0]));
        }

        return dp[dp.length - 1];
    }
}`