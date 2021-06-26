class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self) -> str:
        return "val : {}".format(self.val)


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        rev = None
        fast = head
        slow = head

        while fast and fast.next:
            fast = fast.next.next
            rev, rev.next, slow = slow, rev, slow.next

        if fast:
            slow = slow.next

        while slow:
            if slow.val != rev.val:
                return False

            slow, rev = slow.next, rev.next

        return True

head = ListNode(val=1, next=ListNode(val=2, next=ListNode(val=1)))
print(Solution().isPalindrome(head))