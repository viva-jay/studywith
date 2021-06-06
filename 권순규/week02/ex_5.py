class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)

        def expand(left: int, right: int):
            while left >= 0 and right < length:
                if s[left] != s[right]:
                    break
                left -= 1
                right += 1

            return s[left + 1: right]

        if length < 2 or s == s[::-1]:
            return s

        result = ""
        for i in range(length):
            even_len = expand(i, i + 1)
            odd_len = expand(i, i + 2)
            result = max(result, even_len, odd_len, key=len)

        return result
