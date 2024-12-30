public class Q1639 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"acca","bbbb","caca"};
        String target = "aba";

        System.out.println(sol.numWays(words, target));
    }
}

class Solution {
    private int MOD = (int)1e9 + 7;

    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        
        int[][] count = new int[26][m];
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                count[word.charAt(i) - 'a'][i]++;
            }
        }

        long[] dp = new long[n + 1];
        dp[0] = 1;

        Output.print(dp);
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0; j--) {
                char targetChar = target.charAt(j - 1);
                dp[j] = (dp[j] + dp[j - 1] * count[targetChar - 'a'][i]) % MOD;
                Output.print(dp);
            }
        }

        return (int) dp[n];
    }
}

class Output {
    public static <T> void print(T[] array) {
        for (T value : array) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }

    public static void print(long[] array) {
        for (long value : array) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
    }
}