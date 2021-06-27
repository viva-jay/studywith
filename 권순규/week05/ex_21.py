class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        root = ListNode()
        head = root

        while l1 and l2:
            if l1.val <= l2.val:
                head.next = l1
                l1 = l1.next
            else:
                head.next = l2
                l2 = l2.next

            head = head.next


        if l1:
            head.next = l1
        elif l2:
            head.next = l2

        return root.next

    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if (not l1) or (l2 and l1.val > l2.val):
            l1, l2 = l2, l1

        if l1:
            l1.next = self.mergeTwoLists(l1.next, l2)

        return l1

li1 = ListNode(1, ListNode(5))
li2 = ListNode(1, ListNode(2, ListNode(4)))

node = Solution().mergeTwoLists(li1, li2)
result = []
while node:
    result.append(node.val)
    node = node.next

print(result)