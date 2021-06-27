#include <iostream>
#include <vector>
#include <algorithm>

std::vector<int> twoSum(std::vector<int>& nums, int target)
{
	int _size = nums.size();
	std::vector<int> result;

	for (int i = 0; i < _size; i++)
	{
		bool is_find = false;

		for (int j = 0; j < _size; j++)
		{
			if (i == j)
				continue;

			if (target == nums[i] + nums[j])
			{
				if (i < j)
				{
					result.push_back(i);
					result.push_back(j);
				}
				else
				{
					result.push_back(j);
					result.push_back(i);
				}

				is_find = true;
				break;
			}
		}

		if (true == is_find)
			break;
	}

	return result;
}

int main()
{
	int target;
	std::vector<int> data;

	std::vector<int> result = twoSum(data, target);
	return 0;
}