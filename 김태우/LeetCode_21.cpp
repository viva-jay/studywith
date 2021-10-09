//#include <iostream>
//
//struct ListNode
//{
//	int val;
//	ListNode *next;
//	ListNode() : val(0), next(nullptr) {}
//	ListNode(int x) : val(x), next(nullptr) {}
//	ListNode(int x, ListNode *next) : val(x), next(next) {}
//};
//
//ListNode* mergeTwoLists(ListNode* l1, ListNode* l2)
//{
//	ListNode* head = nullptr;
//	ListNode* tail = nullptr;
//
//	while (nullptr != l1 && nullptr != l2)
//	{
//		if (l1->val < l2->val)
//		{
//			ListNode* new_node = new ListNode(l1->val);
//			l1 = l1->next;
//
//			if (head == nullptr)
//			{
//				head = new_node;
//				tail = new_node;
//			}
//			else
//			{
//				tail->next = new_node;
//				tail = new_node;
//			}
//		}
//		else if (l1->val > l2->val)
//		{
//			ListNode* new_node = new ListNode(l2->val);
//			l2 = l2->next;
//
//			if (head == nullptr)
//			{
//				head = new_node;
//				tail = new_node;
//			}
//			else
//			{
//				tail->next = new_node;
//				tail = new_node;
//			}
//		}
//		else
//		{
//			ListNode* new_node1 = new ListNode(l1->val);
//			l1 = l1->next;
//
//			ListNode* new_node2 = new ListNode(l2->val);
//			l2 = l2->next;
//
//			new_node1->next = new_node2;
//
//			if (head == nullptr)
//			{
//				head = new_node1;
//				tail = new_node2;
//			}
//			else
//			{
//				tail->next = new_node1;
//				tail = new_node2;
//			}
//		}
//	}
//
//	if (l1 != nullptr)
//	{
//		while (l1 != nullptr)
//		{
//			ListNode* new_node = new ListNode(l1->val);
//			l1 = l1->next;
//
//			if (head == nullptr)
//			{
//				head = new_node;
//				tail = new_node;
//			}
//			else
//			{
//				tail->next = new_node;
//				tail = new_node;
//			}
//		}
//	}
//	else if (l2 != nullptr)
//	{
//		while (l2 != nullptr)
//		{
//			ListNode* new_node = new ListNode(l2->val);
//			l2 = l2->next;
//
//			if (head == nullptr)
//			{
//				head = new_node;
//				tail = new_node;
//			}
//			else
//			{
//				tail->next = new_node;
//				tail = new_node;
//			}
//		}
//	}
//
//	return head;
//}
//
//int main()
//{
//	ListNode* l1;
//	ListNode* l2;
//
//	mergeTwoLists(l1, l2);
//	return 0;
//}