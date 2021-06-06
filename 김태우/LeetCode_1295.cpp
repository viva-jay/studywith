#include <iostream>
#include <vector>

int findNumbers(std::vector<int>& nums)
{
	int count = 0;
	int _size = nums.size();

	for (int i = 0; i < _size; i++)
	{
		int data_length = 0;
		int data = nums[i];

		while (data != 0)
		{
			data /= 10;
			data_length++;
		}

		if (data_length % 2 == 0)
			count++;
	}

	return count;
}

int main()
{
	std::vector<int> nums;
	findNumbers(nums);

	return 0;
}