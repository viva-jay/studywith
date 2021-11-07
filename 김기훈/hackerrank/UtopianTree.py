#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'utopianTree' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER n as parameter.
#

arr = [1]

def utopianTree(n):
    for i in range(len(arr), n+1):
        arr.insert(i, arr[i-1] * 2 if i % 2 == 1 else arr[i-1] + 1)
    return arr[n]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        result = utopianTree(n)
        print(result)

        fptr.write(str(result) + '\n')

    fptr.close()
