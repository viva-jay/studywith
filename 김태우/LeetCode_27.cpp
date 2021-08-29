#include <iostream>
#include <vector>

int removeElement(std::vector<int>& nums, int val)
{
	std::vector<int> new_vec;

	int count = 0;
	for (auto temp : nums)
	{
		if (temp == val)
			count++;
		else
		{
			new_vec.push_back(temp);
		}
	}

	int result = nums.size() - count;

	nums = new_vec;
	return result;
}


int main()
{
	std::vector<int> data{ 3,2,2,3 };

	int result = removeElement(data, 3);
	return 0;
}