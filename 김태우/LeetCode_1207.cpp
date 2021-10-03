//#include <iostream>
//#include <vector>
//
//bool uniqueOccurrences(std::vector<int>& arr)
//{
//	std::vector<int> count_check(2000, 0);
//	std::vector<int> result(2000, 0);
//	int _size = arr.size();
//	for (int i = 0; i < _size; i++)
//	{
//		arr[i] += 1000;
//		count_check[arr[i]]++;
//	}
//
//	for (int i = 0; i < 2000; i++)
//	{
//		if (count_check[i] == 0)
//			continue;
//
//		result[count_check[i]]++;
//	}
//
//	for (int i = 0; i < 2000; i++)
//	{
//		if (1 < result[i])
//			return false;
//	}
//
//	return true;
//}
//
//int main()
//{
//	std::vector<int> arr{ -3,0,1,-3,1,1,1,-3,10,0 };
//	bool result = uniqueOccurrences(arr);
//	getchar();
//
//
//	return 0;
//}