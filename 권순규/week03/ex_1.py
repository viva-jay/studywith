from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tmp = {}
        for i, num in enumerate(nums):
            tmp[num] = i

        for i, num in enumerate(nums):
            key = target - num
            if key in tmp and tmp[key] != i:
                return [i, tmp[key]]

        return []
