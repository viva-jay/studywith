#include <iostream>
#include <vector>

bool isPalindrome(int x)
{
	if (x < 0)
		return false;
	else if (x == 0)
		return true;

	std::vector<int> data;
	while (x != 0)
	{
		data.push_back(x % 10);
		x /= 10;
	}

	int begin = 0;
	int end = data.size() - 1;

	bool is_same = true;
	while (begin != end)
	{
		if (data[begin] != data[end])
		{
			is_same = false;
			break;
		}

		begin++;
		end--;

		if (data.size() % 2 == 0)
		{
			if (begin == end + 1)
				break;
		}
	}

	return is_same;
}

int main()
{
	isPalindrome();
	return 0;
}