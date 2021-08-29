#include <iostream>
#include <string>
#include <algorithm>

std::string addBinary(std::string a, std::string b)
{
	std::string result_data{};

	std::reverse(a.begin(), a.end());
	std::reverse(b.begin(), b.end());

	int a_size = a.size();
	int b_size = b.size();
	int min_data = std::min(a_size, b_size);

	int carry = 0;
	for (int i = 0; i < min_data; i++)
	{
		int a_data = static_cast<int>(a[i] - '0');
		int b_data = static_cast<int>(b[i] - '0');

		int result = a_data + b_data + carry;

		if (result == 2)
		{
			result = 0;
			carry = 1;
		}
		else if (result == 3)
		{
			result = 1;
			carry = 1;
		}
		else
			carry = 0;

		result_data += std::to_string(result);
	}

	if (a_size < b_size)
	{
		int remain_index = b_size - a_size;
		for (int i = b_size - remain_index; i < b_size; i++)
		{
			int b_data = static_cast<int>(b[i] - '0');

			int result = b_data + carry;

			if (result == 2)
			{
				result = 0;
				carry = 1;
			}
			else
				carry = 0;

			result_data += std::to_string(result);
		}

	}
	else if (b_size < a_size)
	{
		int remain_index = a_size - b_size;
		for (int i = a_size - remain_index; i < a_size; i++)
		{
			int a_data = static_cast<int>(a[i] - '0');

			int result = a_data + carry;

			if (result == 2)
			{
				result = 0;
				carry = 1;
			}
			else
				carry = 0;

			result_data += std::to_string(result);
		}
	}

	if (carry == 1)
		result_data += std::to_string(carry);

	std::reverse(result_data.begin(), result_data.end());

	return result_data;
}


int main()
{
	std::string a = "101111";
	std::string b = "10";
	std::string result = addBinary(a, b);
	return 0;
}