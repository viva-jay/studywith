#include <iostream>
#include <vector>

std::vector<int> shuffle(std::vector<int>& nums, int n)
{
	std::vector<int> result;

	for (int i = 0, j = n; i < n; i++, j++)
	{
		result.push_back(nums[i]);
		result.push_back(nums[j]);
	}

	return result;
}

int main()
{
	std::vector<int> data;
	std::vector<int> result = shuffle(data, data.size());

	return 0;
}