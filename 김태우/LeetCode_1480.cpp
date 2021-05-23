#include <iostream>
#include <vector>

std::vector<int> runningSum(std::vector<int>& nums)
{
	int _size = nums.size();
	for (int i = 1; i < _size; i++)
	{
		nums[i] += nums[i - 1];
	}

	return nums;
}

int main()
{
	std::vector<int> test_data{ 1,2,3,4 };
	std::vector<int> result = runningSum(test_data);
	return 0;
}

/*
	=== 접근 방법 ===

	- prefix_sum 이용
*/