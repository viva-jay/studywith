#include <iostream>
#include <stack>

int reverse(int x)
{
	long long result = 0;
	long long value = 1;

	std::stack<int> _st;

	while (x != 0)
	{
		_st.push(x % 10);
		x /= 10;
	}

	while (false == _st.empty())
	{
		result += value * _st.top();
		_st.pop();
		value *= 10;
	}

	if (result < INT_MIN || INT_MAX < result)
		return 0;
	else
		return result;
}

int main()
{
	int x;
	int result = reverse(x);

	return 0;
}