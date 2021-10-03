#include <iostream>
#include <string>
#include <sstream>

int countSegments(std::string s)
{
	int count = 0;
	std::stringstream ss(s);
	std::string data;
	while (ss >> data)
	{
		count++;
	}

	return count;
}

int main()
{
	std::string data = "love live! mu'sic forever";
	int result = countSegments(data);

	return 0;
}