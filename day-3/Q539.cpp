#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution
{
public:
    int findMinDifference(vector<string>& timePoints) {
        vector<int> timeValues(timePoints.size());
        for (int i = 0; i < timePoints.size(); ++i) {
            int colonIdx = timePoints[i].find(':');
            int hours = stoi(timePoints[i].substr(0, colonIdx));
            int minutes = stoi(timePoints[i].substr(colonIdx + 1));

            minutes += hours * 60;
            timeValues[i] = minutes;
        }
        sort(timeValues.begin(), timeValues.end());
        
        int minDiff = INT_MAX;
        for (int i = 1; i < timeValues.size(); ++i) {
            minDiff = min(minDiff, timeValues[i] - timeValues[i - 1]);
        }

        return min(minDiff, 1440 - timeValues.back() + timeValues[0]);
    }
};

int main() {
    Solution sol;
    vector<string> timePoints;
    timePoints.push_back("00:00");
    timePoints.push_back("23:59");
    timePoints.push_back("00:00");
    cout << sol.findMinDifference(timePoints) << endl;
    return -1;
}