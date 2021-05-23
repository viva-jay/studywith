#include <iostream>
#include <string>

int minPartitions(std::string n)
{
	int max_data = 0;
	int _size = n.size();

	for (int i = 0; i < _size; i++)
	{
		int data = (int)(n[i] - '0');
		if (max_data < data)
			max_data = data;
	}

	return max_data;
}

int main()
{
	std::string test_data = "27346209830709182346";
	minPartitions(test_data);

	return 0;
}

/*
					=== 접근 방법 ===

	- 0 과 1로만 구성된 값이며 '0011' 과 같은 데이터는 허용x
	- 각 자리 수 중 가장 큰 값을 얻으면 됨
	- atoi 함수가 지원되지 않아 강제로 정수로 변경하는 편법 사용
*/