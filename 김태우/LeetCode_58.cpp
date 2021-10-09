#include <iostream>
#include <string>
#include <sstream>
#include <vector>

int lengthOfLastWord(std::string s)
{
	std::vector<std::string> vec_str;

	std::stringstream ss;
	ss.str(s);

	std::string str;
	while (ss >> str)
	{
		vec_str.push_back(str);
	}

	std::string result_str = vec_str[vec_str.size() - 1];
	return result_str.size();
}

int main()
{
	std::string str;
	lengthOfLastWord(str);

	return 0;
}