#include <iostream>
#include <string>
#include <algorithm>

std::string mergeAlternately(std::string word1, std::string word2) 
{
	int size1 = word1.size();
	int size2 = word2.size();
	int max_size = std::max(size1, size2);


	std::string result = "";
	for (int i = 0; i < max_size; i++)
	{
		if (i < word1.size())
		{
			result += word1.at(i);
		}

		if (i < word2.size())
		{
			result += word2.at(i);
		}
	}

	return result;
}

int main()
{
	std::string s1 = "ab";
	std::string s2 = "pqrs";
	mergeAlternately(s1, s2);
	return 0;
}