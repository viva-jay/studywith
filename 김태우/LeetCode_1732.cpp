#include <iostream>
#include <vector>

int largestAltitude(std::vector<int>& gain)
{
	std::vector<int> result;

	result.push_back(0);
	result.push_back(gain[0]);

	int size = gain.size();
	for (int i = 1; i < size; i++)
	{
		gain[i] += gain[i - 1];
		result.push_back(gain[i]);
	}

	int max_data = 0;
	for (int i = 0; i < result.size(); i++)
	{
		if (max_data < result[i])
			max_data = result[i];
	}

	return max_data;
}

int main()
{
	std::vector<int> gain;
	int result = largestAltitude(gain);

	return 0;
}