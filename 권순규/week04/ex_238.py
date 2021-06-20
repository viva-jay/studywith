from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        p = 1
        out = []
        for i in range(len(nums)):
            out.append(p)
            p *= nums[i]

        p = 1
        for i in range(len(nums) - 1, 0 - 1, -1):
            out[i] *= p
            p *= nums[i]

        return out


print(Solution().productExceptSelf([2,3,4,5]))
print(Solution().productExceptSelf([1,2,3,4]))
print(Solution().productExceptSelf([-1,1,0,-3,3]))
