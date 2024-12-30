public class Q1639 {
    public static String labeledDivider(String label, int length, char ch) {
        int padding = (length - label.length() - 2) / 2;
        String pad = String.valueOf(ch).repeat(Math.max(0, padding));
        return pad + " " + label + " " + pad;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";

        System.out.println(sol.numWays(words, target));
        System.out.println(Divider.labeled("END", 40, '=', Divider.RED));
    }
}

class Divider {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static String plain(int length, char ch, String color) {
        return color + String.valueOf(ch).repeat(length) + RESET;
    }

    public static String labeled(String label, int length, char ch, String color) {
        int padding = (length - label.length() - 2) / 2;
        String pad = String.valueOf(ch).repeat(Math.max(0, padding));
        return color + pad + " " + label + " " + pad + RESET;
    }
}

class Solution {
    private int MOD = (int)1e9 + 7;

    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        
        int[][] count = new int[26][m];
        for (String word : words) {
            System.out.println(word);
            for (int i = 0; i < m; i++) {
                count[word.charAt(i) - 'a'][i]++;
            }
            Output.print(count);
        }

        System.out.println(Divider.labeled("COUNT ARRAY", 40, '*', Divider.GREEN));
        Output.print(count);

        long[] dp = new long[n + 1];
        dp[0] = 1;

        System.out.println(Divider.labeled("DP Solution", 40, '*', Divider.GREEN));
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0; j--) {
                char targetChar = target.charAt(j - 1);
                dp[j] = (dp[j] + dp[j - 1] * count[targetChar - 'a'][i]) % MOD;
                Output.print(dp, j, targetChar);
            }
        }

        System.out.println(Divider.labeled("RESULT", 40, '*', Divider.GREEN));
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

    public static void print(int[][] arrays) {
        int i = 0;
        for (int[] array : arrays) {
            System.out.print((char)('a' + i) + ": ");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.print("\n");
            ++i;
        }
    }

    public static void print(long[] array, int j, char targetChar) {
        int i = 0;

        System.out.print(targetChar + ": ");
        for (long value : array) {
            if (i == j) {
                System.out.print(Divider.GREEN + (value > 0 ? value - array[j - 1] : 0) + Divider.RESET + " ");
            } else if (i == j - 1) {
                System.out.print(Divider.RED + value + Divider.RESET + " ");
            } else {
                System.out.print(value + " ");
            }

            if (i == 0) {
                System.out.print("| ");
            }
            ++i;
        }
        System.out.print(" -> " + (array[j] > 0 ? array[j] - array[j - 1] : 0) + " + " + Divider.RED + array[j - 1] + Divider.RESET + " = " + Divider.GREEN + array[j] + Divider.RESET);
        System.out.print("\n\n");
    }
}