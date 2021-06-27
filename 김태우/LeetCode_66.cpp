#include <iostream>
#include <vector>

std::vector<int> plusOne(std::vector<int>& digits)
{
	int carry = 0;
	int index = digits.size() - 1;
	for (int i = 0; i < digits.size(); i++)
	{
		if (i == 0)
			digits[index] = digits[index] + 1;
		else
			digits[index] = digits[index] + carry;

		if (digits[index] == 10)
		{
			digits[index] = 0;
			carry = 1;
			index--;
		}
		else
		{
			carry = 0;
			break;
		}
	}

	if (carry == 1)
		digits.insert(digits.begin(), 1);

	return digits;
}

int main()
{
	std::vector<int> data;

	std::vector<int> result = plusOne(data);
	return 0;
}
