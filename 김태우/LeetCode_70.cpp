#include <iostream>
#include <vector>

int climbStairs(int n)
{
	std::vector<int> stairs(n + 1);
	stairs[0] = 1;
	stairs[1] = 1;

	for (int i = 2; i <= n; i++)
	{
		int temp = stairs[i - 1];

		if (0 <= i - 2)
			temp += stairs[i - 2];

		stairs[i] = temp;
	}

	return stairs[n];
}

int main()
{
	int result = climbStairs(2);
	return 0;
}