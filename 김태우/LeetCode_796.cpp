//#include <iostream>
//#include <string>
//
//bool rotateString(std::string s, std::string goal)
//{
//	int _size = s.size();
//	for (int i = 0; i < _size; i++)
//	{
//		int result = s.compare(goal);
//
//		if (result == 0)
//			return true;
//
//		s = s.substr(1, std::string::npos) + s.substr(0, 1);
//	}
//
//	return false;
//}
//
//int main()
//{
//	std::string a = "abcde";
//	std::string b = "cdeab";
//
//	bool result = rotateString(a, b);
//	getchar();
//
//	return 0;
//}