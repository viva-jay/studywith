#include <iostream>
#include <vector>
#include <string>

bool checkIfPangram(std::string sentence)
{
	std::vector<bool> result(26);

	int size = sentence.size();
	for (int i = 0; i < size; i++)
	{
		result[(int)sentence[i] - 'a'] = true;
	}

	bool is_success = true;
	for (int i = 0; i < 26; i++)
	{
		if (false == result[i])
		{
			is_success = false;
		}
	}

	return is_success;
}

int main()
{
	std::string sample = "";
	bool result = checkIfPangram(sample);

	return 0;
}