#include <iostream>
#include <algorithm>
#include <vector>

int maximumWealth(std::vector< std::vector<int> >& accounts)
{
	int return_value = 0;
	int _size = accounts.size();
	for (int i = 0; i < _size; i++)
	{
		int temp_sum = 0;
		int inner_size = accounts[i].size();
		for (int j = 0; j < inner_size; j++)
		{
			temp_sum += accounts[i][j];
		}

		return_value = std::max(return_value, temp_sum);
	}

	return return_value;
}

int main()
{
	std::vector< std::vector<int> > accounts;
	maximumWealth(accounts);

	return 0;
}

