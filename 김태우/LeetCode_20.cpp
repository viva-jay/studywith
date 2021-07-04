#include <iostream>
#include <stack>
#include <string>

bool isValid(std::string s) 
{
	std::stack<char> _stack;

	int _size = s.size();
	for (int i = 0; i < _size; i++)
	{
		if (s[i] == '[' || s[i] == '(' || s[i] == '{')
			_stack.push(s[i]);
		else
		{
			if (true == _stack.empty())
			{
				return false;
			}
			else
			{
				char data = _stack.top();
				_stack.pop();
				
				if ((s[i] == ']' && data == '[') || (s[i] == ')' && data == '(') || (s[i] == '}' && data == '{'))
				{
				}
				else
					return false;
			}
		}
	}

	if (true == _stack.empty())
		return true;

	return false;
}

int main()
{
	std::string data = "(])";
	isValid(data);

	return 0;
}