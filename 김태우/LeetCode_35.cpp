#include <iostream>
#include <vector>
#include <algorithm>

int searchInsert(std::vector<int>& nums, int target) 
{
	auto result = std::lower_bound(nums.begin(), nums.end(), target);
	if (nums.end() == result)
	{
		return nums.size();
	}

	return result - nums.begin();
}

int main()
{
	std::vector<int> data{ 1, 3, 5, 6 };
	int result = searchInsert(data, 5);

	return 0;
}