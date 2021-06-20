#include <algorithm>
#include <string>

std::string toLowerCase(std::string s)
{
	std::transform(s.begin(), s.end(), s.begin(), ::tolower);
	return s;
}

int main()
{
	std::string s;
	toLowerCase(s);
	
	return 0;
}