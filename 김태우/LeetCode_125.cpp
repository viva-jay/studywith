#include <iostream>
#include <string>
#include <algorithm>

bool isPalindrome(std::string s)
{
	std::string new_string;
	std::transform(s.begin(), s.end(), s.begin(), ::tolower);

	for (auto temp : s)
	{
		if (('a' <= temp && temp <= 'z') || ('0' <= temp && temp <= '9'))
			new_string += temp;
	}

	int size = new_string.size();
	if (size & 1 == 1)
	{
		for (int i = 0, j = size - 1; i != j; i++, j--)
		{
			if (new_string[i] != new_string[j])
				return false;
		}
	}
	else
	{
		for (int i = 0, j = size - 1; i <= j; i++, j--)
		{
			if (new_string[i] != new_string[j])
				return false;
		}
	}

	return true;
}

int main()
{
	std::string a = "0P";

	bool result = isPalindrome(a);
	return 0;
}