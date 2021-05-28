class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = [w.lower() for w in s if w.isalnum()]
        return s == s[::-1]
