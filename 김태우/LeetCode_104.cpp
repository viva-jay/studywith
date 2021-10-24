#include <iostream>
#include <algorithm>
#include <queue>

struct TreeNode
{
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

struct LevelTraval
{
	TreeNode* _node;
	int _level;

	LevelTraval(TreeNode* node, int level)
	{
		_node = node;
		_level = level;
	}
};

int maxDepth(TreeNode* root)
{
	int max_level = 0;

	if (nullptr == root)
		return max_level;

	std::queue<LevelTraval> _q;
	_q.push(LevelTraval(root, 1));

	while (_q.empty() == false)
	{
		LevelTraval temp = _q.front();
		_q.pop();

		max_level = std::max(max_level, temp._level);

		if (nullptr != temp._node->left)
		{
			_q.push(LevelTraval(temp._node->left, temp._level + 1));
		}

		if (nullptr != temp._node->right)
		{
			_q.push(LevelTraval(temp._node->right, temp._level + 1));
		}
	}

	return max_level;
}

int main()
{



}