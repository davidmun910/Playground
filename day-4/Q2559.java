class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        int[] prefix = new int[words.length + 1];

        for (int i = 0; i < words.length; ++i) {
            if (isVowel((words[i].charAt(0))) &&
                isVowel((words[i].charAt(words[i].length() - 1)))) {
                    prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }

        for (int i = 0; i < queries.length; ++i) {
            result[i] = prefix[queries[i][1] + 1] - prefix[queries[i][0]];
        }


        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}