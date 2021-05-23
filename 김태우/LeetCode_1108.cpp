#include <iostream>
#include <string>

std::string defangIPaddr(std::string address)
{
	size_t index = -2;
	while (true)
	{
		index = address.find(".", index + 2);

		if (index == address.npos)
			break;

		address.replace(index, 1, "[.]");
	}

	return address;
}

int main()
{
	std::string address = "1.1.1.1";
	defangIPaddr(address);

	return 0;
}

/*
									=== 접근 방법 ===

	- 단순 문자열 변경
	- find 함수를 통해 해당 위치를 찾고 원하는 위치에서 변경할 크기만큼 변경될 문자열로 치환
		-> 사용자 정의 replaceAll() 함수 구성 방식 
*/