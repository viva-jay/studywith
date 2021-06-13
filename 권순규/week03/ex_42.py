from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        left_index, right_index = 0, len(height) - 1
        left_max, right_max = 0, 0

        result = 0
        while left_index < right_index:
            left_height, right_height = height[left_index], height[right_index]
            left_max, right_max = max(left_max, left_height), max(right_max, right_height)

            if left_max <= right_max:
                result += left_max - left_height
                left_index += 1
            else:
                result += right_max - right_height
                right_index -= 1

        return result

print(Solution().trap(height = [0,1,0,2,1,0,1,3,2,1,2,1]))
print(Solution().trap(height = [4,2,0,3,2,5]))
