//#include <iostream>
//#include <vector>
//#include <string>
//#include <algorithm>
//
//std::string longestCommonPrefix(std::vector<std::string>& strs)
//{
//	int min_value = INT_MAX;
//	int vec_size = strs.size();
//	std::string return_str = "";
//
//	if (vec_size == 1)
//		return strs[0];
//
//	for (int i = 0; i < vec_size; i++)
//		min_value = std::min(min_value, (int)strs[i].size());
//
//	for (int i = 0; i < min_value; i++)
//	{
//		bool is_different = false;
//		char comp_str = strs[0][i];
//
//		for (int j = 1; j < vec_size; j++)
//		{
//			if (comp_str != strs[j][i])
//			{
//				is_different = true;
//				break;
//			}
//
//			if (j == vec_size - 1)
//				return_str += comp_str;
//		}
//
//		if (is_different == true)
//			break;
//	}
//
//	return return_str;
//}
//
//int main()
//{
//	std::vector<std::string> vec{ "dog","racecar","car" };
//	auto temp = longestCommonPrefix(vec);
//
//	return 0;
//}