#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> vowelStrings(vector<string>& words, vector<vector<int>>& queries) {
        vector<char> vowels = {'a', 'e', 'i', 'o', 'u'};
        unordered_set<char> vowelSet(vowels.begin(), vowels.end());
        vector<int> prefixSum(words.size() + 1, 0);
        vector<int> result;

        for (int i = 0; i < words.size(); ++i) {
            bool isValid = vowelSet.count(words[i].front()) && vowelSet.count(words[i].back());
            prefixSum[i + 1] = prefixSum[i] + (isValid ? 1 : 0);
        }

        for (auto& query : queries) {
            int l = query[0];
            int r = query[1];
            result.push_back(prefixSum[r + 1] - prefixSum[l]);
        }

        return result;
    }
};