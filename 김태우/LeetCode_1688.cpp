#include <iostream>

int numberOfMatches(int n)
{
	int result = 0;

	while (n != 1)
	{
		if (n % 2 == 0)
		{
			n /= 2;
			result += n;
		}
		else
		{
			result += (n - 1) / 2;
			n = (n - 1) / 2 + 1;
		}
	}

	return result;
}

int main()
{
	int s = 7;
	numberOfMatches(s);
	
	return 0;
}