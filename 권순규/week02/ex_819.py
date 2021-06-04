import collections
import re
from typing import List


class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        banned = set(banned)
        words = [word.lower() for word in re.findall(r"[a-zA-Z]+", paragraph.lower()) if word not in banned]
        counts = collections.Counter(words)
        return counts.most_common(1)[0][0]
