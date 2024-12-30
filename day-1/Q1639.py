from typing import List


class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        
        for i in range(len(target)):
            print(target)

class Main:
    solution = Solution()
    words = ["acca","bbbb","caca"]
    target = "aba"
    solution.numWays(words, target)