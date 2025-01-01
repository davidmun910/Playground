#include <iostream>
#include <vector>
#include <algorithm>

class Solution
{
public:
    int mincostTickets(std::vector<int>& days, std::vector<int>& costs) {
        std::vector<int> dp(days.size() + 1);
        int l_30 = 0, l_7 = 0, l_1 = 0;

        dp[0] = 0;
        for (int r = 1; r <= days.size(); ++r)
        {
            while (days[r - 1] - days[l_30] + 1 > 30 && l_30 <= r) {
                ++l_30;
            }
            while (days[r - 1] - days[l_7] + 1 > 7 && l_7 <= r) {
                ++l_7;
            }
            while (days[r - 1] - days[l_1] + 1 > 1 && l_1 <= r) {
                ++l_1;
            }

            std::cout << l_30 << " " << l_7 << " " << l_1 << std::endl;

            dp[r] = std::min(std::min(dp[l_30] + costs[2], dp[l_7] + costs[1]), dp[l_1] + costs[0]);
        }

        std::cout << "DP: ";
        for (int i = 0; i < dp.size(); ++i)
        {
            std::cout << dp[i] << " ";
        }
        std::cout << std::endl;

        return dp.back();
    }
};

int main() {
    Solution sol;
    std::vector<int> days;
    days.push_back(1);
    days.push_back(4);
    days.push_back(6);
    days.push_back(7);
    days.push_back(8);
    days.push_back(20);

    std::vector<int> costs;
    costs.push_back(2);
    costs.push_back(7);
    costs.push_back(15);

    std::cout << "Days: ";
    for (int i = 0; i < days.size(); ++i) {
        std::cout << days[i] << " ";
    }
    std::cout << std::endl;

    std::cout << "Costs: ";
    for (int i = 0; i < costs.size(); ++i)
    {
        std::cout << costs[i] << " ";
    }
    std::cout << std::endl;

    if (sol.mincostTickets(days, costs) != 11)
        std::cout << "ERROR" << std::endl;
    return -1;
}
