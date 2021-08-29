#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'caesarCipher' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER k
#

def caesarCipher(s, k):
    str_list = []
    for i in range(0, len(s)):
        c = s[i]
        if ord('a') <= ord(c) <= ord('z'):
            str_list.append(chr(ord('a') + ((ord(c) + k - ord('a')) % 26)))
        elif ord('A') <= ord(c) <= ord('Z'):
            str_list.append(chr(ord('A') + ((ord(c) + k - ord('A')) % 26)))
        else:
            str_list.append(c)
    return ''.join(str_list)


if __name__ == '__main__':
    #fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    s = input()

    k = int(input().strip())

    result = caesarCipher(s, k)
    print(result)

    #fptr.write(result + '\n')

    #fptr.close()
