#include <iostream>

struct ListNode
{
	int val;
	ListNode *next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* deleteDuplicates(ListNode* head)
{
	ListNode* temp = head;

	while (temp != nullptr)
	{
		ListNode* next_temp = temp->next;

		if (nullptr != next_temp && temp->val == next_temp->val)
		{
			temp->next = next_temp->next;
		}
		else
			temp = temp->next;
	}

	return head;
}

int main()
{
	return 0;
}