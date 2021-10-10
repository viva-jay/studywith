#include <iostream>
#include <vector>

int removeDuplicates(std::vector<int>& nums)
{
	int count = 0;
	int _size = nums.size();
	for (auto iter = nums.begin(); iter != nums.end();)
	{
		if (nums.end() != iter + 1)
		{
			if (*iter == *(iter + 1))
			{
				count++;
				nums.erase(iter + 1);
			}
			else
				++iter;
		}
		else if (nums.end() == iter + 1)
			++iter;
	}

	return _size - count;
}

int main()
{
	std::vector<int> arr{ 1,1,2,2,3 };
	int result = removeDuplicates(arr);
	return 0;
}